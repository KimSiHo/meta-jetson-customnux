import spidev
import time
import gpiod
import sys
from gpiod import line

DC_PIN = 106
RST_PIN = 41
CHIP = "/dev/gpiochip0"

WIDTH = 128
HEIGHT = 160

MAX_SPI_CHUNK = 4096   # Jetson safe limit


def fail(msg):
    print("[FAIL] " + msg)
    sys.exit(1)

def info(msg):
    print("[INFO] " + msg)


def init_gpio():
    info("Opening gpiochip...")

    try:
        chip = gpiod.Chip(CHIP)
    except Exception as e:
        fail(f"gpiochip open 실패: {e}")

    info(f"Requesting DC={DC_PIN}, RST={RST_PIN} lines...")

    try:
        dc = chip.request_lines(
            consumer="st7735-dc",
            config={
                DC_PIN: gpiod.LineSettings(
                    direction=line.Direction.OUTPUT,
                    output_value=line.Value.INACTIVE
                )
            }
        )

        rst = chip.request_lines(
            consumer="st7735-rst",
            config={
                RST_PIN: gpiod.LineSettings(
                    direction=line.Direction.OUTPUT,
                    output_value=line.Value.ACTIVE
                )
            }
        )

    except Exception as e:
        fail(f"GPIO 라인 request 실패: {e}")

    info("GPIO 초기화 성공.")
    return dc, rst


def init_spi():
    info("Opening SPI /dev/spidev0.0...")

    try:
        spi = spidev.SpiDev()
        spi.open(0, 0)
        spi.max_speed_hz = 24000000
        spi.mode = 0
    except Exception as e:
        fail(f"SPI open 실패: {e}")

    info("SPI 초기화 성공.")
    return spi


def cmd(spi, dc_req, c):
    try:
        dc_req.set_values({DC_PIN: line.Value.INACTIVE})  # Command mode
        spi.xfer([c])
    except Exception as e:
        fail(f"cmd(0x{c:02X}) 전송 실패: {e}")


def data(spi, dc_req, d):
    try:
        dc_req.set_values({DC_PIN: line.Value.ACTIVE})

        for i in range(0, len(d), MAX_SPI_CHUNK):
            spi.xfer(d[i:i+MAX_SPI_CHUNK])

    except Exception as e:
        fail(f"data 전송 실패: {e}")


def hw_reset(rst_req):
    info("Hardware reset...")

    try:
        rst_req.set_values({RST_PIN: line.Value.INACTIVE})
        time.sleep(0.05)
        rst_req.set_values({RST_PIN: line.Value.ACTIVE})
        time.sleep(0.05)
    except Exception as e:
        fail(f"RST 핀 제어 실패: {e}")

    info("Reset OK.")


def st7735_init(spi, dc, rst):
    info("ST7735 초기화 시작...")

    hw_reset(rst)

    try:
        cmd(spi, dc, 0x01)  # SWRESET
        time.sleep(0.15)

        cmd(spi, dc, 0x11)  # SLPOUT
        time.sleep(0.12)

        cmd(spi, dc, 0x26)
        data(spi, dc, [0x04])

        cmd(spi, dc, 0x3A)
        data(spi, dc, [0x05])

        cmd(spi, dc, 0x36)
        data(spi, dc, [0xC0])

        cmd(spi, dc, 0x29)
        time.sleep(0.02)
    except Exception as e:
        fail(f"ST7735 초기화 실패: {e}")

    info("ST7735 초기화 완료.")


def set_window(spi, dc, x0, y0, x1, y1):
    try:
        cmd(spi, dc, 0x2A)
        data(spi, dc, [0, x0, 0, x1])

        cmd(spi, dc, 0x2B)
        data(spi, dc, [0, y0, 0, y1])

        cmd(spi, dc, 0x2C)
    except Exception as e:
        fail(f"set_window 실패: {e}")


def fill_color(spi, dc, r, g, b):
    info(f"Fill color RGB({r},{g},{b})...")

    try:
        color = ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
        buf = [color >> 8, color & 0xFF]

        pixels = WIDTH * HEIGHT
        bigbuf = buf * pixels

        set_window(spi, dc, 0, 0, WIDTH - 1, HEIGHT - 1)
        data(spi, dc, bigbuf)
    except Exception as e:
        fail(f"fill_color 실패: {e}")

    info("화면 색칠 성공.")


if __name__ == "__main__":
    info("GPIO 초기화…")
    dc, rst = init_gpio()

    info("SPI 초기화…")
    spi = init_spi()

    st7735_init(spi, dc, rst)

    fill_color(spi, dc, 255, 255, 0)

    info("모든 작업 완료. (성공)")

    while True:
        time.sleep(1)

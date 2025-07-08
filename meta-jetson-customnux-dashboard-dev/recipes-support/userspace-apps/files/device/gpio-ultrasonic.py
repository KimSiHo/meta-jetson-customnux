import gpiod
import time
from gpiod import line

TRIG_LINE = 41
ECHO_LINE = 85
CHIP = "/dev/gpiochip0"


def _measure_distance(trig_req, echo_req):
    # LOW
    trig_req.set_values({TRIG_LINE: line.Value.INACTIVE})
    time.sleep(0.05)

    # 10us HIGH
    trig_req.set_values({TRIG_LINE: line.Value.ACTIVE})
    time.sleep(0.00001)
    trig_req.set_values({TRIG_LINE: line.Value.INACTIVE})

    # Echo HIGH 측정
    while echo_req.get_value(ECHO_LINE) == line.Value.INACTIVE:
        print("1")
        pulse_start = time.time()

    while echo_req.get_value(ECHO_LINE) == line.Value.ACTIVE:
        print("2")
        pulse_end = time.time()

    pulse_duration = pulse_end - pulse_start
    distance = pulse_duration * 17150

    return round(distance, 2)


def _prepare_gpio():
    chip = gpiod.Chip(CHIP)

    trig_req = chip.request_lines(
        consumer="hc-sr04",
        config={
            TRIG_LINE: gpiod.LineSettings(
                direction=line.Direction.OUTPUT,
                output_value=line.Value.INACTIVE
            )
        }
    )

    echo_req = chip.request_lines(
        consumer="hc-sr04",
        config={
            ECHO_LINE: gpiod.LineSettings(
                direction=line.Direction.INPUT,
            )
        }
    )

    return trig_req, echo_req


def measure_distance_test():
    trig_req, echo_req = _prepare_gpio()

    try:
        while True:
            dist = _measure_distance(trig_req, echo_req)
            print(f"Distance: {dist} cm")
            time.sleep(1)
    except KeyboardInterrupt:
        print("Stopped")


def measure_distance():
    trig_req, echo_req = _prepare_gpio()

    try:
        dist = _measure_distance(trig_req, echo_req)
        return dist
    finally:
        pass


if __name__ == "__main__":
    measure_distance_test()

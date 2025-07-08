import gpiod
import time
from gpiod import line

CHIP = "/dev/gpiochip0"
DC = 106
RESET = 41

chip = gpiod.Chip(CHIP)

dc = chip.request_lines(
    consumer="dc",
    config={DC: gpiod.LineSettings(
        direction=line.Direction.OUTPUT,
        output_value=line.Value.INACTIVE
    )}
)

reset = chip.request_lines(
    consumer="reset",
    config={RESET: gpiod.LineSettings(
        direction=line.Direction.OUTPUT,
        output_value=line.Value.INACTIVE
    )},
)

while True:
    print("DC ON.")
    dc.set_values({DC: line.Value.ACTIVE})
    time.sleep(5)
    dc.set_values({DC: line.Value.INACTIVE})

    print("RESET ON.")
    reset.set_values({RESET: line.Value.ACTIVE})
    time.sleep(5)
    reset.set_values({RESET: line.Value.INACTIVE})

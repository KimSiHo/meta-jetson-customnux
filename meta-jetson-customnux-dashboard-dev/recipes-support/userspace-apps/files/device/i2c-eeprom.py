#!/usr/bin/env python3
import struct

EEPROM_PATH = "/sys/bus/i2c/devices/7-0050/eeprom"

# ----------------------------
# 저수준 read/write 함수
# ----------------------------
def eeprom_read(offset, length):
    with open(EEPROM_PATH, "rb") as f:
        f.seek(offset)
        return f.read(length)

def eeprom_write(offset, data: bytes):
    with open(EEPROM_PATH, "r+b") as f:
        f.seek(offset)
        f.write(data)


# ----------------------------
# 고수준 API (구조화된 데이터)
# ----------------------------

def write_version(version: int):
    eeprom_write(0x00, struct.pack("<I", version))

def read_version():
    return struct.unpack("<I", eeprom_read(0x00, 4))[0]


def write_product_id(pid: int):
    eeprom_write(0x04, struct.pack("<I", pid))

def read_product_id():
    return struct.unpack("<I", eeprom_read(0x04, 4))[0]


def write_device_name(name: str):
    name_bytes = name.encode("utf-8")
    name_bytes = name_bytes[:16]                      # 최대 16바이트
    name_bytes = name_bytes + b"\x00"*(16-len(name_bytes))
    eeprom_write(0x08, name_bytes)

def read_device_name():
    data = eeprom_read(0x08, 16)
    return data.split(b"\x00", 1)[0].decode("utf-8")


def write_temp_offset(value: float):
    eeprom_write(0x18, struct.pack("<f", value))

def read_temp_offset():
    return struct.unpack("<f", eeprom_read(0x18, 4))[0]


# ----------------------------
# 테스트
# ----------------------------
if __name__ == "__main__":
    print("Writing sample data into EEPROM...")

    write_version(1)
    write_product_id(12345)
    write_device_name("MyJetsonDevice")
    write_temp_offset(2.75)

    print("Reading back...")

    print("version       =", read_version())
    print("product_id    =", read_product_id())
    print("device_name   =", read_device_name())
    print("temp_offset   =", read_temp_offset())

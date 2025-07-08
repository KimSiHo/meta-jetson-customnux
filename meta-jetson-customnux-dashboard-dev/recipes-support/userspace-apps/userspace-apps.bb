SUMMARY = "User Space Apps"
LICENSE = "CLOSED"

SRC_URI = " \
    file://opencv/hello-world.py \
    file://cuda/hello-world.cu \
    file://cuda/Makefile \
    file://cuda/docker-compose.yaml \
    file://camera/test.sh \
    file://device/gpio-test.py \
    file://device/gpio-ultrasonic.py \
    file://device/i2c-eeprom.py \
    file://device/spi-drm.py \
"

S = "${WORKDIR}"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}/opencv
    install -m 0644 ${S}/opencv/hello-world.py ${D}/home/${DEFAULT_USER}/opencv/hello-world.py

    install -d ${D}/home/${DEFAULT_USER}/cuda
    install -m 0644 ${S}/cuda/hello-world.cu ${D}/home/${DEFAULT_USER}/cuda/hello-world.cu
    install -m 0644 ${S}/cuda/Makefile ${D}/home/${DEFAULT_USER}/cuda/Makefile
    install -m 0644 ${S}/cuda/docker-compose.yaml ${D}/home/${DEFAULT_USER}/cuda/docker-compose.yaml

    install -d ${D}/home/${DEFAULT_USER}/camera
    install -m 0644 ${S}/camera/test.sh ${D}/home/${DEFAULT_USER}/camera/test.sh

    install -d ${D}/home/${DEFAULT_USER}/device
    install -m 0644 ${S}/device/gpio-test.py ${D}/home/${DEFAULT_USER}/device/gpio-test.py
    install -m 0644 ${S}/device/gpio-ultrasonic.py ${D}/home/${DEFAULT_USER}/device/gpio-ultrasonic.py
    install -m 0644 ${S}/device/i2c-eeprom.py ${D}/home/${DEFAULT_USER}/device/i2c-eeprom.py
    install -m 0644 ${S}/device/spi-drm.py ${D}/home/${DEFAULT_USER}/device/spi-drm.py

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}
}

FILES:${PN} += " \
    /home/${DEFAULT_USER} \
"

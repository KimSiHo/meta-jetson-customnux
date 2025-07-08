SUMMARY = "User Space Apps"
LICENSE = "CLOSED"

SRC_URI = " \
    file://opencv/hello-world.py \
    file://cuda/hello-world.cu \
    file://cuda/Makefile \
    file://cuda/docker-compose.yaml \
    file://camera/test.sh \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}/opencv
    install -m 0644 ${S}/opencv/hello-world.py ${D}/home/${DEFAULT_USER}/opencv/hello-world.py

    install -d ${D}/home/${DEFAULT_USER}/cuda
    install -m 0644 ${S}/cuda/hello-world.cu ${D}/home/${DEFAULT_USER}/cuda/hello-world.cu
    install -m 0644 ${S}/cuda/Makefile ${D}/home/${DEFAULT_USER}/cuda/Makefile
    install -m 0644 ${S}/cuda/docker-compose.yaml ${D}/home/${DEFAULT_USER}/cuda/docker-compose.yaml

    install -d ${D}/home/${DEFAULT_USER}/camera
    install -m 0644 ${S}/camera/test.sh ${D}/home/${DEFAULT_USER}/camera/test.sh
}

FILES:${PN} += " \
    /home/${DEFAULT_USER} \
"

SUMMARY = "ZeroMQ SUB test script"
LICENSE = "CLOSED"

SRC_URI = "file://sub.py"

RDEPENDS:${PN} += "python3-pyzmq"

S = "${WORKDIR}"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}
    install -m 0755 ${S}/sub.py ${D}/home/${DEFAULT_USER}/sub.py

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}
}

FILES:${PN} += "/home/${DEFAULT_USER}/sub.py"

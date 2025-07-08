SUMMARY = "vision docker settings"
LICENSE = "CLOSED"

SRC_URI += " \
    file://compose.yml \
    file://compose.stg.yml \
    file://compose.real.yml \
"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}
    install -m 0755 ${WORKDIR}/compose.yml ${D}/home/${DEFAULT_USER}/compose.yml
    install -m 0755 ${WORKDIR}/compose.stg.yml ${D}/home/${DEFAULT_USER}/compose.stg.yml
    install -m 0755 ${WORKDIR}/compose.real.yml ${D}/home/${DEFAULT_USER}/compose.real.yml
}

FILES:${PN} += " \
    /home/${DEFAULT_USER} \
"

SUMMARY = "vision project docker settings"
LICENSE = "CLOSED"

SRC_URI += " \
    file://compose.yml \
    file://compose.stg.yml \
    file://compose.real.yml \
"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}
    install -m 0644 ${WORKDIR}/compose.yml ${D}/home/${DEFAULT_USER}/compose.yml
    install -m 0644 ${WORKDIR}/compose.stg.yml ${D}/home/${DEFAULT_USER}/compose.stg.yml
    install -m 0644 ${WORKDIR}/compose.real.yml ${D}/home/${DEFAULT_USER}/compose.real.yml

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}
}

FILES:${PN} += " \
    /home/${DEFAULT_USER} \
"

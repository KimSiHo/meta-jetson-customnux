FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://01-netcfg.yaml \
    file://02-docker.yaml \
"

do_install:append() {
    install -d ${D}${sysconfdir}/netplan
    install -m 0644 ${WORKDIR}/01-netcfg.yaml ${D}${sysconfdir}/netplan/01-netcfg.yaml
    install -m 0644 ${WORKDIR}/02-docker.yaml ${D}${sysconfdir}/netplan/02-docker.yaml
}

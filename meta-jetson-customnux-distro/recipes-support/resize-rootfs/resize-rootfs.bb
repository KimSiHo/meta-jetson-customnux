SUMMARY = "A one-shot service to resize the root filesystem on first boot"
LICENSE = "CLOSED"

SRC_URI = " \
    file://resize-rootfs.sh \
    file://resize-rootfs.service \
"

inherit systemd
SYSTEMD_SERVICE:${PN} = "resize-rootfs.service"

RDEPENDS:${PN} = "e2fsprogs-resize2fs"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/resize-rootfs.sh ${D}${sbindir}/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/resize-rootfs.service ${D}${systemd_system_unitdir}/
}


FILES:${PN} += " \
    ${sbindir}/resize-rootfs.sh \
    ${systemd_system_unitdir}/resize-rootfs.service \
"

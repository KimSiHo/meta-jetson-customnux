FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://daemon.conf \
"

DEPENDS += "project-user"
RDEPENDS:${PN} += "project-user"

do_install:append() {
    install -d ${D}${systemd_user_unitdir}/default.target.wants
    ln -s ../pulseaudio.service ${D}${systemd_user_unitdir}/default.target.wants/pulseaudio.service

    install -d ${D}/home/${DEFAULT_USER}/.config/pulse
    install -m 0644 ${WORKDIR}/daemon.conf ${D}/home/${DEFAULT_USER}/.config/pulse/daemon.conf

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}
}

FILES:${PN} += " \
    ${systemd_user_unitdir}/default.target.wants \
    /home/${DEFAULT_USER} \
"

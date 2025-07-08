SUMMARY = "vision project asset files"
LICENSE = "CLOSED"

SRC_URI += " \
    file://track1.mp3 \
    file://track2.mp3 \
    file://track3.mp3 \
"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_install() {
    install -d ${D}/opt/assets
    install -m 0644 ${WORKDIR}/track1.mp3 ${D}/opt/assets/track1.mp3
    install -m 0644 ${WORKDIR}/track2.mp3 ${D}/opt/assets/track2.mp3
    install -m 0644 ${WORKDIR}/track3.mp3 ${D}/opt/assets/track3.mp3

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/opt/assets
}

FILES:${PN} += " \
    /opt/assets \
"

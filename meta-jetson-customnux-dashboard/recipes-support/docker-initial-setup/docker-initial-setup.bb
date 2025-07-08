SUMMARY = "Initial setup script to load pre-downloaded Docker images"
LICENSE = "CLOSED"

SRC_URI = " \
    file://initial-docker-load.sh \
    file://initial-docker-load.service \
"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/l4t-cuda_12.2.12-devel.tar;unpack=0;name=l4t-cuda"
SRC_URI[l4t-cuda.sha256sum] = "328ec58d1ba55c0742bf3fd2c3ae86d53984d60fcdb9dcdfe01ea106b0d3f692"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/l4t-base_35.3.1.tar;unpack=0;name=l4t-base"
SRC_URI[l4t-base.sha256sum] = "d66669b5c6df85c7e7943142fbacd985eb37a86c0d93b25e114edef20c952628"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ds71_arm64.tar;unpack=0;name=ds71_arm64"
SRC_URI[ds71_arm64.sha256sum] = "d66669b5c6df85c7e7943142fbacd985eb37a86c0d93b25e114edef20c952628"

inherit systemd
SYSTEMD_SERVICE:${PN} = "initial-docker-load.service"

RDEPENDS:${PN} = "docker"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/initial-docker-load.sh ${D}${sbindir}/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/initial-docker-load.service ${D}${systemd_system_unitdir}/

    install -d ${D}${datadir}/docker-images
    install -m 0644 ${WORKDIR}/ds71_arm64.tar ${D}${datadir}/docker-images/
#    install -m 0644 ${WORKDIR}/l4t-base_35.3.1.tar ${D}${datadir}/docker-images/
#    install -m 0644 ${WORKDIR}/l4t-cuda_12.2.12-devel.tar ${D}${datadir}/docker-images/
}

FILES:${PN} += " \
    ${sbindir}/initial-docker-load.sh \
    ${systemd_system_unitdir}/initial-docker-load.service \
    ${datadir}/docker-images/*.tar \
"

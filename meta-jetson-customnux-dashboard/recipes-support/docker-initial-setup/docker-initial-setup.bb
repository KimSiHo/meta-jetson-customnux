SUMMARY = "Initial setup script to load pre-downloaded Docker images"
LICENSE = "CLOSED"

SRC_URI = " \
    file://initial-docker-load.sh \
    file://initial-docker-load.service \
"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-backend-stg.tar;unpack=0;name=ai-vision-backend-stg"
SRC_URI[ai-vision-backend-stg.sha256sum] = "e8023e8a8697a71993b52a676b1cc6ba9e61cc28d4fc2beecab04e8e046d3fe8"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-frontend-stg.tar;unpack=0;name=ai-vision-frontend-stg"
SRC_URI[ai-vision-frontend-stg.sha256sum] = "90044c3f11ce9df9d344af11465a219a24aef3914f16217ae8d9649756783247"

inherit systemd
SYSTEMD_SERVICE:${PN} = "initial-docker-load.service"

RDEPENDS:${PN} = "docker"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/initial-docker-load.sh ${D}${sbindir}/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/initial-docker-load.service ${D}${systemd_system_unitdir}/

    install -d ${D}${datadir}/docker-images
    install -m 0644 ${WORKDIR}/ai-vision-frontend-stg.tar ${D}${datadir}/docker-images/
    install -m 0644 ${WORKDIR}/ai-vision-backend-stg.tar ${D}${datadir}/docker-images/
}

FILES:${PN} += " \
    ${sbindir}/initial-docker-load.sh \
    ${systemd_system_unitdir}/initial-docker-load.service \
    ${datadir}/docker-images/*.tar \
"

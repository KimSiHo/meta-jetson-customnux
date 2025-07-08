SUMMARY = "Initial setup script to load pre-downloaded Docker images"
LICENSE = "CLOSED"

SRC_URI = " \
    file://initial-docker-load.sh \
    file://initial-docker-load.service \
"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-backend-stg.tar;unpack=0;name=ai-vision-backend-stg"
SRC_URI[ai-vision-backend-stg.sha256sum] = "d27bdcad998e71a146c26a8581fc58d4acda739d9e1f086333a0d34ff2bf100f"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-frontend-stg.tar;unpack=0;name=ai-vision-frontend-stg"
SRC_URI[ai-vision-frontend-stg.sha256sum] = "a4a9214e615b29a092a07763cf6acfc1be3273d67fc24488b1fa451a04b07df2"

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

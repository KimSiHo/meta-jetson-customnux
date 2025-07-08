SUMMARY = "Initial setup script to load pre-downloaded Docker images"
LICENSE = "CLOSED"

SRC_URI = " \
    file://initial-docker-load.sh \
    file://initial-docker-load.service \
"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-backend-stg.tar;unpack=0;name=ai-vision-backend-stg"
SRC_URI[ai-vision-backend-stg.sha256sum] = "92ee9c29fbc2ed0f25a96bec583d9a7c51e1a56d131a6180a3b33cb90ffa8022"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-frontend-stg.tar;unpack=0;name=ai-vision-frontend-stg"
SRC_URI[ai-vision-frontend-stg.sha256sum] = "fc56b1856cc0f0375c57012f9a20b488a59dca3381bdbf92fb69f1a60debbb59"

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

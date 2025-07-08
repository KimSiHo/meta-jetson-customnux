SUMMARY = "Initial setup script to load pre-downloaded Docker images"
LICENSE = "CLOSED"

SRC_URI = " \
    file://initial-docker-load.sh \
    file://initial-docker-load.service \
"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-backend-stg.tar;unpack=0;name=ai-vision-backend-stg"
SRC_URI[ai-vision-backend-stg.sha256sum] = "80690c44e57fe71d944adb1bed32c4b03a6e8050bfa14bc70abcd988691ee119"

SRC_URI += "https://siho-docker-images.s3.ap-northeast-2.amazonaws.com/ai-vision-frontend-stg.tar;unpack=0;name=ai-vision-frontend-stg"
SRC_URI[ai-vision-frontend-stg.sha256sum] = "9d6ea64a617d8d559219b18f6f7099180bae86de83ac910d72900bf79d1d73c1"

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

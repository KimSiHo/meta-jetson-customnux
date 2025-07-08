SUMMARY = "vision ai backend application"
DESCRIPTION = "Backend service for camera vision project"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit externalsrc cmake pkgconfig systemd

EXTERNALSRC = "/home/sihokim/projects/vision-backend"
EXTERNALSRC_BUILD = "${WORKDIR}/build"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

DEPENDS += " \
    vision-common \
"

# DEPENDS += " \
#     vision-common \
#     cppzmq \
#     nlohmann-json \
#     spdlog \
#     fmt \
#     gstreamer1.0 \
#     gstreamer1.0-plugins-base \
#     tbb \
# "


SRC_URI += "file://vision-backend.service"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "vision-backend.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/vision_backend ${D}${bindir}/vision_backend

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/vision-backend.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += " \
    ${bindir}/vision_backend \
    ${systemd_unitdir}/system/vision-backend.service \
"

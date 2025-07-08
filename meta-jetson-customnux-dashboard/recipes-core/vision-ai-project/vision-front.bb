SUMMARY = "vsion ai front application"
DESCRIPTION = "Frontend service for camera vision project"
LICENSE = "CLOSED"

inherit externalsrc cmake cmake_qt5 pkgconfig

EXTERNALSRC = "/home/sihokim/projects/vision-frontend"
EXTERNALSRC_BUILD = "${WORKDIR}/build"

DEPENDS += " \
    vision-common \
    qtbase \
    qtquickcontrols2 \
"

# DEPENDS += " \
#     vision-common \
#     cppzmq \
#     qtbase \
#     qtquickcontrols2 \
#     gstreamer1.0 \
#     gstreamer1.0-plugins-base \
# "

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/src/vision_frontend ${D}${bindir}/vision_frontend
}

FILES:${PN} += "${bindir}/vision_frontend"

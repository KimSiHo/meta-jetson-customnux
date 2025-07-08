SUMMARY = "vsion ai front application"
DESCRIPTION = "Frontend service for camera vision project"
LICENSE = "CLOSED"

inherit externalsrc cmake cmake_qt5 pkgconfig

EXTERNALSRC = "/home/sihokim/projects/vision-frontend"
EXTERNALSRC_BUILD = "${WORKDIR}/build"

DEPENDS += "qtbase"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/src/vision-frontend ${D}${bindir}/vision-frontend
}

FILES:${PN} += "${bindir}/vision-frontend"

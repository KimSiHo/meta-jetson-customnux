SUMMARY = "vsion ai common"
DESCRIPTION = "Common for camera vision project"
LICENSE = "CLOSED"

inherit externalsrc cmake cmake_qt5 pkgconfig

EXTERNALSRC = "/home/sihokim/projects/vision-common"
EXTERNALSRC_BUILD = "${WORKDIR}/build"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

do_install() {
}

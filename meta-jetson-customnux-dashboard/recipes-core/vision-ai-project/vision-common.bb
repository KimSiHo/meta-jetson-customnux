SUMMARY = "ai vision common"
DESCRIPTION = "common project for ai vision"
LICENSE = "CLOSED"

inherit externalsrc cmake pkgconfig

EXTERNALSRC = "/home/sihokim/projects/vision-common"
EXTERNALSRC_BUILD = "${WORKDIR}/build"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

DEPENDS += " \
    cppzmq \
    spdlog \
"

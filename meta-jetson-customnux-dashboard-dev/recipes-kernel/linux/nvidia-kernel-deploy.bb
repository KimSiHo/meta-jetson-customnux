SUMMARY = "deploy kernel source for develop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/KimSiHo/nvidia-kernel.git;protocol=https;branch=custom/oe4t-patches-l4t-r36.4-1012.12"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}/nvidia-kernel
    cp -r ${S}/. ${D}/home/${DEFAULT_USER}/nvidia-kernel/

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}/nvidia-kernel
}

FILES:${PN} = "/home/${DEFAULT_USER}/nvidia-kernel"

INSANE_SKIP:${PN} += "file-rdeps"

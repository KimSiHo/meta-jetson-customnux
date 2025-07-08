SUMMARY = "deploy nvidia oot source for develop"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/KimSiHo/nvidia-oot.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}/home/${DEFAULT_USER}/nvidia-oot
    cp -r ${S}/. ${D}/home/${DEFAULT_USER}/nvidia-oot/

    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}/nvidia-oot
}

FILES:${PN} = "/home/${DEFAULT_USER}/nvidia-oot"

INSANE_SKIP:${PN} += "file-rdeps"

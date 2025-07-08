DESCRIPTION = "custom settings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

S = "${WORKDIR}"
SRC_URI = " \
    file://vim/vimrc \
    file://bash/bashrc \
    file://bash/bash.bashrc \
    file://bash/custom-profile.sh \
    file://bash/camera-alias \
    file://dircolors/dircolors \
    file://desktop/disable-screensaver.sh \
"

DEPENDS = "project-user"
RDEPENDS:${PN} += "project-user"

do_install() {
#    install -d ${D}/etc/profile.d/
#    install -m 0644 ${S}/bash/custom-profile.sh ${D}/etc/profile.d

    # vim 설정
    install -d ${D}/home/root/.vim/
    install -m 0644 ${S}/vim/vimrc ${D}/home/root/.vim/
    install -d ${D}/home/${DEFAULT_USER}/.vim/
    install -m 0644 ${S}/vim/vimrc ${D}/home/${DEFAULT_USER}/.vim/

    # bash 설정
    install -d ${D}/etc/
    install -m 0644 ${S}/bash/bash.bashrc ${D}/etc

    install -d ${D}/home/root/
    install -m 0644 ${S}/bash/bashrc ${D}/home/root/.bashrc
    install -m 0644 ${S}/bash/camera-alias ${D}/home/root/.camera-alias

    install -d ${D}/home/${DEFAULT_USER}/
    install -m 0644 ${S}/bash/camera-alias ${D}/home/${DEFAULT_USER}/.camera-alias

    # dircolors 설정
    install -d ${D}/home/root/
    install -m 0644 ${S}/dircolors/dircolors ${D}/home/root/.dircolors
    install -d ${D}/home/${DEFAULT_USER}/
    install -m 0644 ${S}/dircolors/dircolors ${D}/home/${DEFAULT_USER}/.dircolors

    # desktop 설정
    install -d ${D}/home/root/.config/autostart
    install -m 0644 ${S}/desktop/disable-screensaver.sh ${D}/home/root/.config/autostart/disable-screensaver.sh
    install -d ${D}/home/${DEFAULT_USER}/.config/autostart
    install -m 0644 ${S}/desktop/disable-screensaver.sh ${D}/home/${DEFAULT_USER}/.config/autostart/disable-screensaver.sh

    # 파일 권한 설정
    chown -R ${DEFAULT_USER}:${DEFAULT_GROUP} ${D}/home/${DEFAULT_USER}
}

FILES:${PN} += " \
    /etc/profile.d \
    /home/root/ \
    /home/${DEFAULT_USER}/ \
"

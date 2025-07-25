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
    file://dircolors/dircolors \
    file://desktop/disable-screensaver.sh \
"

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
    install -d ${D}/home/${DEFAULT_USER}/
    install -m 0644 ${S}/bash/bashrc ${D}/home/${DEFAULT_USER}/.bashrc

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
}

FILES:${PN} += " \
    /etc/profile.d \
    /home/root/ \
    /home/${DEFAULT_USER}/ \
"

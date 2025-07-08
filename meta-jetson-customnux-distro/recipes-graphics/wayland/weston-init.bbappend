FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://great-autologin \
"

do_install:append() {
	if [ "${@bb.utils.filter('DISTRO_FEATURES', 'pam', d)}" ]; then
		install -D -p -m0644 ${WORKDIR}/great-autologin ${D}${sysconfdir}/pam.d/great-autologin
	fi
}
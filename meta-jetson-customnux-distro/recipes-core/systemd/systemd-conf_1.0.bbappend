FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://journald-persistence.conf \
"

do_install:append() {
	install -D -m0644 ${WORKDIR}/journald-persistence.conf ${D}${systemd_unitdir}/journald.conf.d/00-journald-persistence.conf
}

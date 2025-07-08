SUMMARY = "User Dashboard App"
LICENSE = "CLOSED"

require project-variables.inc

S = "${WORKDIR}"

do_install() {
    install -d ${D}${DASHBOARD_PROJECT_DIR}
}

FILES:${PN} += " \
    ${DASHBOARD_PROJECT_DIR} \
"

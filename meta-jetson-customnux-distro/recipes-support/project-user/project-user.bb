SUMMARY = "Creates the project user and group"
LICENSE = "CLOSED"

DEPENDS = "bash"

ALLOW_EMPTY:${PN} = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-g 1000 ${DEFAULT_GROUP}"
USERADD_PARAM:${PN} = "-u 1000 -g 1000 -s /bin/bash ${DEFAULT_USER}"

SUMMARY = "Creates the project user and group"
LICENSE = "CLOSED"

DEPENDS = "bash"
USERADD_DEPENDS = "weston-init systemd docker-moby"
RDEPENDS:${PN} = "weston-init systemd docker-moby"

ALLOW_EMPTY:${PN} = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-g 1001 ${DEFAULT_GROUP}"
USERADD_PARAM:${PN} = "-u 1001 -g 1001 -s /bin/bash -G video,input,render,wayland,systemd-journal,docker ${DEFAULT_USER}"

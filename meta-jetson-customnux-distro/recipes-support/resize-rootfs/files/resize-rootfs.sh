#!/bin/sh

FINDMNT="/usr/bin/findmnt"
RESIZE2FS="/usr/sbin/resize2fs"
SYSTEMCTL="/usr/bin/systemctl"
RM="/usr/bin/rm"
TOUCH="/usr/bin/touch"

# Find the root partition device
ROOT_PART=$(${FINDMNT} / -o source -n)

# Run resize2fs on the root partition
${RESIZE2FS} ${ROOT_PART}

# Disable this service so it doesn't run on subsequent boots
${SYSTEMCTL} disable resize-rootfs.service

${RM} -f /usr/sbin/resize-rootfs.sh
${RM} -f /etc/systemd/system/resize-rootfs.service

${TOUCH} /etc/resize-rootfs.done

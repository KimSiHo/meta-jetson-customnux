SUMMARY = "custom image for lunux kernel develop"

inherit customnux-base-image

LINGUAS_KO_KR = "ko-kr"
LINGUAS_EN_US = "en-us"
IMAGE_LINGUAS = "${LINGUAS_KO_KR} ${LINGUAS_EN_US}"
IMAGE_OVERHEAD_FACTOR = "1.3"

# https://docs.yoctoproject.org/4.0.23/ref-manual/features.html#image-features
IMAGE_FEATURES = " \
    splash \
    package-management \
    ssh-server-openssh \
    tools-sdk \
    debug-tweaks \
    weston \
"

IMAGE_FEATURES:qemuarm64-custom = " \
    package-management \
"

IMAGE_INSTALL += " \
    packagegroup-linux-utils \
    kernel-modules \
    opkg \
    bash \
    e2fsprogs-resize2fs \
    resize-rootfs \
"

# postprocess commands
add_commands() {
    [ ! -L ${IMAGE_ROOTFS}/bin/lsmod ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/lsmod
    [ ! -L ${IMAGE_ROOTFS}/bin/insmod ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/insmod
    [ ! -L ${IMAGE_ROOTFS}/bin/rmmod ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/rmmod
    [ ! -L ${IMAGE_ROOTFS}/bin/modinfo ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/modinfo
    [ ! -L ${IMAGE_ROOTFS}/bin/modprobe ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/modprobe
    [ ! -L ${IMAGE_ROOTFS}/bin/depmode ] && ln -s /bin/kmod ${IMAGE_ROOTFS}/bin/depmod
}

update_setting_files() {
    sed -i 's#/bin/sh#/bin/bash#g' ${IMAGE_ROOTFS}/etc/passwd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    add_commands; \
    update_setting_files; \
"

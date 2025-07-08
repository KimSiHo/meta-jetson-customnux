inherit externalsrc

EXTERNALSRC = "/home/sihokim/projects/nvidia-kernel-source"

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-jammy-nvidia-tegra:"
SRC_URI:append = " file://my-localversion.cfg"

KBUILD_DEFCONFIG = "prod_defconfig"

LINUX_VERSION_EXTENSION = "-tegra"

KERNEL_VERSION_SANITY_SKIP="1"

FILES:${PN}-vmlinux = "/boot/vmlinux-${KERNEL_VERSION}"
PACKAGES =+ "${PN}-vmlinux"

do_install:append() {
        install -d ${D}/boot
        install -m 0644 ${B}/vmlinux ${D}/boot/vmlinux-${KERNEL_VERSION}
}

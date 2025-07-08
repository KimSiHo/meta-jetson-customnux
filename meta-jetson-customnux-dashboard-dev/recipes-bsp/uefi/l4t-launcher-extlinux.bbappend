UBOOT_EXTLINUX_LABELS = "primary primary-test"
UBOOT_EXTLINUX_TIMEOUT = "2000"
UBOOT_EXTLINUX_DEFAULT_LABEL = "primary"
UBOOT_EXTLINUX_MENU_TITLE = "L4T boot options"

# ───────────────────────────────
# primary-test 라벨 전용
# ───────────────────────────────
UBOOT_EXTLINUX_KERNEL_IMAGE:primary-test = "/boot/Image-test"
UBOOT_EXTLINUX_INITRD:primary-test = "/boot/initrd-test"

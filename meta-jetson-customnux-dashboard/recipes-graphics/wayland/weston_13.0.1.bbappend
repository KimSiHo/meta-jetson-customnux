PACKAGECONFIG = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'kms wayland egl clients', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'xwayland', '', d)} \
    ${@bb.utils.filter('DISTRO_FEATURES', 'systemd x11', d)} \
    ${@bb.utils.contains_any('DISTRO_FEATURES', 'wayland x11', '', 'headless', d)} \
    image-jpeg \
    screenshare \
    shell-desktop \
    shell-fullscreen \
    shell-ivi \
    shell-kiosk \
"

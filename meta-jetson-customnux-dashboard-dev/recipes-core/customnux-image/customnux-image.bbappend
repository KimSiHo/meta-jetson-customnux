UTILITY_TOOLS = " \
    fbgrab \
    tmux \
    tree \
    curl \
    numlockx \
    tmate \
    gptfdisk \
    gnome-screenshot \
    efibootmgr \
"

PROJECT = " \
    jetson-inference \
"

SETTINGS = " \
    app-settings \
    userspace-apps \
"

NETWORK_TOOLS = " \
    nfs-utils \
    nfs-mount \
    ethtool \
"

DEBUG_TOOLS = " \
    gdb \
    strace \
    systemd-analyze \
"

HARDWARE_TOOLS = " \
    i2c-tools \
    v4l-utils \
    alsa-utils \
    libgpiod \
    libgpiod-tools \
"

IMAGE_INSTALL += " \
    ${UTILITY_TOOLS} \
    ${SETTINGS} \
    ${NETWORK_TOOLS} \
    ${DEBUG_TOOLS} \
    ${HARDWARE_TOOLS} \
"

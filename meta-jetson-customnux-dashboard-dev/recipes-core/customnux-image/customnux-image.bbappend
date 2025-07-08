UTILITY_TOOLS = " \
    fbgrab \
    tmux \
    tree \
    curl \
    tmate \
    gptfdisk \
    efibootmgr \
"

# numlockx
# gnome-screenshot

PROJECT_INSTALL += " \
    zmq-sub \
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

FONT_INSTALL += " \
    fontconfig-utils \
"

IMAGE_INSTALL += " \
    ${UTILITY_TOOLS} \
    ${SETTINGS} \
    ${NETWORK_TOOLS} \
    ${DEBUG_TOOLS} \
    ${HARDWARE_TOOLS} \
"

TOOLCHAIN_TARGET_TASK += " \
    qtbase-dev \
    cppzmq-dev \
    nlohmann-json-dev \
"

TOOLCHAIN_HOST_TASK += " \
    nativesdk-packagegroup-qt5-toolchain-host \
"

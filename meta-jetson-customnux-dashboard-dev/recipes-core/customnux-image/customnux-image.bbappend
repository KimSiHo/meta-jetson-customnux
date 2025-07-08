UTILITY_TOOLS = " \
    fbgrab \
    tmux \
    tree \
    curl \
    numlockx \
    tmate \
    gptfdisk \
    gnome-screenshot \
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

IMAGE_INSTALL += " \
    ${UTILITY_TOOLS} \
    ${SETTINGS} \
    ${NETWORK_TOOLS} \
"

UTILITY_TOOLS = " \
    fbgrab \
    tmux \
    tree \
    bash \
    curl \
    numlockx \
    tmate \
    app-settings \
    gptfdisk \
    gnome-screenshot \
"

NETWORK_TOOLS = " \
    nfs-utils \
    nfs-mount \
    ethtool \
"

IMAGE_INSTALL += " \
    ${UTILITY_TOOLS} \
    ${NETWORK_TOOLS} \
"

FONT_INSTALL += " \
    fontconfig-utils \
"

PROJECT_INSTALL += " \
    zmq-sub \
"

DEVELOP_PROJECT_INSTALL += " \
    nvidia-kernel-deploy \
    nvidia-oot-deploy \
"

UTILITY_TOOLS = " \
    fbgrab \
    tmux \
    tree \
    curl \
    tmate \
    gptfdisk \
    efibootmgr \
    git \
    dtc \
\
    elfutils \
    elfutils-dev \
    bc \
    flex \
    bison \
    openssl \
    perl \
    perl-modules \
    pahole \
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
    libgpiod \
    libgpiod-tools \
"

TEST_INSTALL = " \
    kernel-selftest \
    ltp \
    ptest-runner \
    perf \
    stress-ng \
"

# 개인 별 설정. 빌드 오류 발생하므로 제외 처리.
PERSONAL_CRENDENTIAL_TOOLS = " \
    remote-develop \
"

IMAGE_INSTALL += " \
    ${UTILITY_TOOLS} \
    ${SETTINGS} \
    ${NETWORK_TOOLS} \
    ${DEBUG_TOOLS} \
    ${HARDWARE_TOOLS} \
    ${TEST_INSTALL} \
    ${DEVELOP_PROJECT_INSTALL} \
    ${PERSONAL_CRENDENTIAL_TOOLS} \
"

TOOLCHAIN_TARGET_TASK += " \
    qtbase-dev \
    cppzmq-dev \
    nlohmann-json-dev \
    spdlog-dev \
    fmt-dev \
"

TOOLCHAIN_HOST_TASK += " \
    nativesdk-packagegroup-qt5-toolchain-host \
"

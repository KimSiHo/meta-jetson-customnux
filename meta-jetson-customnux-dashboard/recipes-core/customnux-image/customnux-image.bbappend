BSP_INSTALL = " \
    kernel-devsrc rsync \
    tegra-tools \
    linux-jammy-nvidia-tegra-vmlinux \
"

BPF_INSTALL = " \
    bpftool \
    bpftrace \
    bcc \
"

DBUS_INSTALL = " \
    dbus \
    dbus-glib \
    python3-dbus \
"

CUDA_INSTALL = " \
    cuda-toolkit \
    cuda-nvcc \
    cuda-nvcc-headers \
    cuda-libraries \
    cuda-cudart-dev \
"

TENSOR_INSTALL = " \
    tensorrt-core \
    tensorrt-plugins-prebuilt \
"

DOCKER_INSTALL = " \
    docker-compose \
    nvidia-docker \
"

CAMERA_INSTALL = " \
    v4l-utils \
"
# todo delete
#     gstreamer1.0 \
#     gstreamer1.0-plugins-base \
#     gstreamer1.0-plugins-good \
#     gstreamer1.0-plugins-bad \
#     gstreamer1.0-plugins-tegra \
#     gstreamer1.0-python
#     opencv


FONT_INSTALL = " \
    fontconfig \
    source-han-sans-kr-fonts \
"

PYTHON_INSTALL = " \
    python3 \
    python3-pip \
    python3-numpy \
    python3-logging \
    python3-drgn \
"

AUDIO_INSTALL = " \
    alsa-lib \
    alsa-utils \
    alsa-plugins \
    pulseaudio \
    pulseaudio-server \
    pavucontrol \
    pulseaudio-module-switch-on-connect \
    pulseaudio-misc \
"

BLUETOOTH_INSTALL = " \
    bluez5 \
    libpulse \
    ofono \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-policy \
    pulseaudio-module-bluez5-discover \
    pulseaudio-module-bluez5-device \
"

MISC_INSTALL = " \
    upower \
    python3-jetson-stats \
    tegra-libraries-multimedia-ds \
    libglvnd \
    tegra-libraries-eglcore \
    libxkbcommon \
"

PROJECT_INSTALL = " \
    vision-docker-settings \
    vision-assets \
"

# todo 커널 배포 자주해서 잠시 비활성화
#docker-initial-setup

IMAGE_INSTALL:append = " \
    ${BSP_INSTALL} \
    ${BPF_INSTALL} \
    ${DBUS_INSTALL} \
    ${CUDA_INSTALL} \
    ${TENSOR_INSTALL} \
    ${DOCKER_INSTALL} \
    ${CAMERA_INSTALL} \
    ${FONT_INSTALL} \
    ${PYTHON_INSTALL} \
    ${AUDIO_INSTALL} \
    ${BLUETOOTH_INSTALL} \
    ${MISC_INSTALL} \
    ${PROJECT_INSTALL} \
"

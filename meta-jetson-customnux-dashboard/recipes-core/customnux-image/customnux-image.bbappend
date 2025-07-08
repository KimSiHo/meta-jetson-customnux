BASIC_INSTALL = " \
    kernel-devsrc \
    kernel-selftest \
    user-dashboard \
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
# todo 빌드 소요 시각 단축으로 잠시 제외
# docker-initial-setup

CAMERA_INSTALL = " \
    gstreamer1.0 \
    gstreamer1.0-dev \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-base-dev \
    gstreamer1.0-python \
    v4l-utils \
    opencv \
"

FONT_INSTALL = " \
    fontconfig \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    source-han-sans-kr-fonts \
"

PYTHON_INSTALL = " \
    python3 \
    python3-pip \
    python3-numpy \
    python3-logging \
    python3-drgn \
"

IMAGE_INSTALL:append = " \
    ${BASIC_INSTALL} \
    ${DBUS_INSTALL} \
    ${CUDA_INSTALL} \
    ${TENSOR_INSTALL} \
    ${DOCKER_INSTALL} \
    ${CAMERA_INSTALL} \
    ${FONT_INSTALL} \
    ${PYTHON_INSTALL} \
"

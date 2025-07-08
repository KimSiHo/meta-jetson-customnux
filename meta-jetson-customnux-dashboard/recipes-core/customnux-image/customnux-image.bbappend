BASIC_INSTALL = " \
    kernel-devsrc \
    kernel-selftest \
    nvidia-docker \
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
    ${PYTHON_INSTALL} \
"

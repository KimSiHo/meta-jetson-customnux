SUMMARY = "NVIDIA's Hello AI World inference toolkit for Jetson"
DESCRIPTION = "This project provides a simple framework and examples for using deep learning inference networks on NVIDIA Jetson."
HOMEPAGE = "https://github.com/dusty-nv/jetson-inference"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=eafbc60fe8e4e62ce0b37714974a87fc"

inherit externalsrc
EXTERNALSRC = "/home/sihokim/projects/jetson-inference"

inherit cmake

DEPENDS += " \
    python3-numpy \
    cuda-nvcc \
    cuda-cudart \
    cuda-nvcc-headers \
    python3-numpy \
    opencv \
"

RDEPENDS:${PN} += "python3-numpy"

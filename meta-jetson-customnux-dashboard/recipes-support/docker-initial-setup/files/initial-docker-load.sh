#!/bin/sh

FLAG_FILE="/etc/docker_images_loaded.flag"
IMAGE_DIR="/usr/share/docker-images"

if [ ! -f "${FLAG_FILE}" ]; then
    echo "Performing first-boot Docker image load..."

    for image_tar in ${IMAGE_DIR}/*.tar; do
        if [ -f "${image_tar}" ]; then
            echo "Loading ${image_tar}..."
            docker load -i "${image_tar}"
        fi
    done

    touch "${FLAG_FILE}"
    echo "First-boot Docker image load complete."
else
    echo "Docker images already loaded. Skipping."
fi

exit 0

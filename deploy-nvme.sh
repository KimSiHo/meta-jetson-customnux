#!/bin/bash

function sound() {
    play -n synth 1
}

# 사용자 설정
DEPLOY_DIR="/media/sihokim/nvidia-poky/build-dashboard-jetson/tmp-glibc/deploy/images/custom-jetson-orin-nano-devkit-nvme"  # deploy 디렉토리 위치
SYMLINK="customnux-image-custom-jetson-orin-nano-devkit-nvme.rootfs.tegraflash.tar.gz"  # deploy 내의 심볼릭 링크 파일 이름
TARGET_DIR="/home/sihokim/nvidia-build/"  # 압축 풀 위치
FLASH_SCRIPT="./initrd-flash"  # 실행할 플래시 스크립트

echo "=== Step 0: deploy 디렉토리로 이동 ==="
cd "$DEPLOY_DIR"
echo "현재 위치: $(pwd)"

echo "=== Step 1: tegraflash.tar.gz 링크 추적 ==="
if [ ! -L "$SYMLINK" ]; then
    echo "에러: 심볼릭 링크 $SYMLINK 가 존재하지 않음"
    exit 1
fi

TARFILE=$(readlink -f "$SYMLINK")
echo "찾은 실제 tar 파일: $TARFILE"

echo "=== Step 2: $TARFILE 를 $TARGET_DIR 로 복사 ==="
cp "$TARFILE" "$TARGET_DIR"

POKY_DIR="$TARGET_DIR/custom-poky-nvme"

echo "=== Step 3: $POKY_DIR 내부 기존 파일 삭제 ==="
cd "$POKY_DIR"
sudo rm -rf ./*

echo "=== Step 4: $TARFILE 압축 해제 ==="
tar -xf "$TARGET_DIR/$(basename "$TARFILE")"

echo "=== Step 5: initrd-flash 실행 ==="
#sudo ./doflash.sh
sudo ./initrd-flash --erase-nvme

echo "=== ✅ Step 6: 완료 ==="
sound

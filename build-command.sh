#!/bin/bash

function sound() {
    play -n synth 1
}

commands=(
    #"bitbake linux-jammy-nvidia-tegra -c cleanall && bitbake linux-jammy-nvidia-tegra"
    "bitbake nvidia-kernel-oot -c cleanall && bitbake nvidia-kernel-oot"
    "bitbake customnux-image -c cleanall && bitbake customnux-image"
)

total_start=$(date +%s)

for cmd in "${commands[@]}"; do
    echo ""
    echo "▶ 실행: $cmd"
    start=$(date +%s)

    if ! bash -c "$cmd"; then
        echo "❌ 실패: $cmd"
        break
    fi

    end=$(date +%s)
    duration=$((end - start))
    echo "⏱️ 실행 시간: ${duration}s"
done

total_end=$(date +%s)
total_duration=$((total_end - total_start))
echo "총 실행 시간: ${total_duration}s"
sound

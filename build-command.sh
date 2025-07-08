#!/bin/bash

function sound() {
    play -n synth 1
}

commands=(
#    "bitbake linux-jammy-nvidia-tegra -c cleanall && bitbake linux-jammy-nvidia-tegra"
#    "bitbake make-mod-scripts -c cleanall && bitbake make-mod-scripts"
#    "bitbake nvidia-kernel-oot -c cleanall && bitbake nvidia-kernel-oot"
#    "bitbake vision-common -c cleanall && bitbake vision-common"
#    "bitbake vision-backend -c cleanall && bitbake vision-backend"
#    "bitbake vision-front -c cleanall && bitbake vision-front"
    "bitbake customnux-image -c cleanall && bitbake customnux-image"
#    "bitbake customnux-image -c populate_sdk"
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



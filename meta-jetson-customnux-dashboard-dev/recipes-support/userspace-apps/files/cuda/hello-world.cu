#include <iostream>
#include <cuda_runtime.h>

/**
 * @brief GPU에서 실행될 커널(Kernel) 함수
 * * __global__ 키워드는 이 함수가 CPU(호스트)에 의해 호출되어
 * * GPU(디바이스)에서 실행된다는 것을 나타냅니다.
 */
__global__ void hello_from_gpu() {
    // threadIdx.x는 현재 실행 중인 스레드의 블록 내 ID를 나타냅니다.
    // GPU의 printf는 모든 스레드의 출력을 버퍼에 모았다가
    // 커널 실행이 끝난 후 한 번에 호스트로 전송합니다.
    printf("Hello, World! from GPU thread %d\n", threadIdx.x);
}

int main() {
    std::cout << "Hello from CPU!" << std::endl;

    // GPU에서 hello_from_gpu 커널을 실행합니다.
    // <<<1, 5>>>는 1개의 스레드 블록(block)에 5개의 스레드(thread)를
    // 생성하여 실행하라는 의미입니다.
    hello_from_gpu<<<1, 5>>>();

    // cudaDeviceSynchronize()는 GPU에서 실행된 모든 작업이
    // 완전히 끝날 때까지 CPU가 기다리도록 하는 동기화 함수입니다.
    // 이 함수가 없으면, GPU가 printf를 실행하기 전에
    // main 함수가 먼저 종료될 수 있습니다.
    cudaDeviceSynchronize();

    std::cout << "Kernel launch finished." << std::endl;

    return 0;
}

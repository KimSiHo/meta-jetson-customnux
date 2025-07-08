import cv2
import numpy as np

# 1. 이미지를 생성합니다.
# 300x500 픽셀 크기의 검은색(0) 이미지를 생성합니다.
# (높이, 너비, 채널 수), np.uint8은 0-255 값을 갖는 데이터 타입입니다.
width, height = 500, 300
image = np.zeros((height, width, 3), np.uint8)

# 2. 이미지에 텍스트를 씁니다.
text = "Hello, OpenCV"
font = cv2.FONT_HERSHEY_SIMPLEX  # 사용할 폰트
font_scale = 1  # 폰트 크기
color = (255, 255, 255)  # 흰색 (BGR 순서)
thickness = 2  # 폰트 두께
text_size = cv2.getTextSize(text, font, font_scale, thickness)[0]

# 텍스트를 이미지 중앙에 위치시키기 위한 좌표 계산
text_x = (width - text_size[0]) // 2
text_y = (height + text_size[1]) // 2

# 이미지에 텍스트를 그립니다.
cv2.putText(image, text, (text_x, text_y), font, font_scale, color, thickness)

# 3. 이미지를 화면에 보여줍니다.
# "Hello World Window" 라는 이름의 창을 생성하고 이미지를 표시합니다.
cv2.imshow("Hello World Window", image)

# 4. 키보드 입력을 대기합니다.
# 0을 인자로 주면 키보드 입력이 있을 때까지 무한정 대기합니다.
# 이 라인이 없으면 창이 바로 닫혀서 이미지를 볼 수 없습니다.
print("Press any key to exit...")
cv2.waitKey(0)

# 5. 모든 창을 닫습니다.
# 프로그램이 종료될 때 생성된 모든 OpenCV 창을 닫아줍니다.
cv2.destroyAllWindows()

print("Window closed. Program finished.")

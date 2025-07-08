gst-launch-1.0 v4l2src device=/dev/video0 ! nvvidconv ! nvoverlaysink

v4l2-ctl --device=/dev/video0 --stream-mmap --stream-count=10 --stream-to=test.raw

gst-launch-1.0 nvarguscamerasrc ! 'video/x-raw(memory:NVMM),width=1920,height=1080,framerate=30/1' ! nvoverlaysink -e

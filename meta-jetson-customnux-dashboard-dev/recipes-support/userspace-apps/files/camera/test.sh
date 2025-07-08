#!/usr/bin/env bash
set -e

if [ $# -ne 1 ]; then
  echo "Usage: $0 {1|2|3|4}"
  exit 1
fi

case "$1" in
  1)
    echo ">>> 1) v4l2src → nvvidconv → nvoverlaysink"
    gst-launch-1.0 v4l2src device=/dev/video0 ! nvvidconv ! nvoverlaysink
    ;;
  2)
    echo ">>> 2) v4l2-ctl mmap 스트림 덤프"
    v4l2-ctl --device=/dev/video0 --stream-mmap --stream-count=10 --stream-to=test.raw
    ;;
  3)
    echo ">>> 3) nvarguscamerasrc 1920x1080@30 → nvoverlaysink"
    gst-launch-1.0 nvarguscamerasrc ! 'video/x-raw(memory:NVMM),width=1920,height=1080,framerate=30/1' ! nvoverlaysink -e
    ;;
  4)
    echo ">>> 4) nvarguscamerasrc 4608x2592@14 → nveglglessink"
    gst-launch-1.0 nvarguscamerasrc ! \
      'video/x-raw(memory:NVMM), width=(int)4608, height=(int)2592, framerate=(fraction)14/1' ! nveglglessink
    ;;
  *)
    echo "Usage: $0 {1|2|3|4}"
    exit 1
    ;;
esac

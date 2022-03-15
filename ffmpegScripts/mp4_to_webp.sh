#!/usr/local/bin/bash

# finds all .mp4 files recursively and convert it to .webp.
# scale 800:-1 will set width to 800 and will adopt height - use for horizontal images. To convert vertical use scale=-1:800

for i in `find . -name "*.mp4" -type f`;
do ffmpeg -y -i "$i" -vcodec libwebp -filter:v fps=fps=20 -lossless 1  -compression_level 3 -q:v 70 -loop 0 -preset picture -an -vsync 0 -filter:v scale=800:-1 "${i%.*}.webp"

#do rm "$i"
done

TARGET = hello-world
SOURCE = hello-world.cu

all: $(TARGET)

$(TARGET): $(SOURCE)
	nvcc $(SOURCE) -o $(TARGET)

clean:
	rm -f $(TARGET)

.PHONY: all clean

from PIL import Image
import matplotlib.pyplot as pyp


def pixelate(image, i_size):
    img = Image.open(image)

    small_img = img.resize(i_size, Image.BILINEAR)
    res = small_img.resize(img.size, Image.NEAREST)

    filename = f"image_{i_size[0]}x{i_size[1]}.png"
    res.save(filename)
    pyp.figure(figsize=(10, 10))
    pyp.subplot(1, 2, 1)
    pyp.title("Original image", size=18)
    pyp.imshow(img) 
    pyp.axis("off")  

    pyp.subplot(1, 2, 2)
    pyp.title(f"Pixel Art {i_size[0]}x{i_size[1]}", size=18)
    pyp.imshow(res)
    pyp.axis("off")

    pyp.show()
pixelate(image="nr.jpg", i_size=(128, 128))

package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Andrey on 24.12.2015.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes e) {
        ImageReader reader;
        if (e == ImageTypes.BMP) {
            reader = new BmpReader();
        } else if (e == ImageTypes.PNG) {
            reader = new PngReader();
        } else if (e == ImageTypes.JPG) {
            reader = new JpgReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}

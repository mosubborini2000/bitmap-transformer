package bitmap.transformer;

import bitmap.transformer.BitMap;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class App {

    private final String inputImagePath = "C:\\bitmap-transformer\\app\\src\\main\\resources\\bit.jpg"; // Replace with the actual absolute path

    @Test
    void testUnableToReadInputFile() {
        assertThrows(IOException.class, () -> {
            BitMap bitmap = new BitMap("nonexistent.bmp");
        });
    }

    @Test
    void testConvertImageToGray() throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));
        BitMap bitmap = new BitMap(inputImagePath);
        bitmap.convertImageToGray();
        BufferedImage grayImage = bitmap.bufferedImage;

        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                Color inputColor = new Color(inputImage.getRGB(i, j));
                Color grayColor = new Color(grayImage.getRGB(i, j));
                int expectedGray = (inputColor.getRed() + inputColor.getGreen() + inputColor.getBlue()) / 3;
                assertEquals(expectedGray, grayColor.getRed());
                assertEquals(expectedGray, grayColor.getGreen());
                assertEquals(expectedGray, grayColor.getBlue());
            }
        }
    }

    @Test
    void testInvertColors() throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));
        BitMap bitmap = new BitMap(inputImagePath);
        bitmap.invertColors();
        BufferedImage invertedImage = bitmap.bufferedImage;

        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                Color inputColor = new Color(inputImage.getRGB(i, j));
                Color invertedColor = new Color(invertedImage.getRGB(i, j));
                assertEquals(255 - inputColor.getRed(), invertedColor.getRed());
                assertEquals(255 - inputColor.getGreen(), invertedColor.getGreen());
                assertEquals(255 - inputColor.getBlue(), invertedColor.getBlue());
            }
        }
    }

    @Test
    void testRotate() throws IOException {
        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));
        BitMap bitmap = new BitMap(inputImagePath);
        bitmap.rotate();
        BufferedImage rotatedImage = bitmap.bufferedImage;

        assertEquals(inputImage.getHeight(), rotatedImage.getWidth());
        assertEquals(inputImage.getWidth(), rotatedImage.getHeight());

        for (int i = 0; i < inputImage.getWidth(); i++) {
            for (int j = 0; j < inputImage.getHeight(); j++) {
                Color inputColor = new Color(inputImage.getRGB(i, j));
                Color rotatedColor = new Color(rotatedImage.getRGB(rotatedImage.getWidth() - j - 1, i));
                assertEquals(inputColor.getRGB(), rotatedColor.getRGB());
            }
        }
    }
}

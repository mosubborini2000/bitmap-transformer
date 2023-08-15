package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitMap {
    BufferedImage bufferedImage;
    public BitMap(String fileName) throws IOException{
        File file=new File(fileName);
        this.bufferedImage=ImageIO.read(file);
    }
    public  void write(String fileName)throws IOException{

        File file=new File(fileName);
        ImageIO.write(this.bufferedImage,"bmp",file);

    }
    public void convertImageToGray() {
        for (int i = 0; i < this.bufferedImage.getWidth(); i++) {
            for (int j = 0; j < this.bufferedImage.getHeight(); j++) {
                //getting RGB color on each pixel
                Color color = new Color(this.bufferedImage.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int a = color.getAlpha();
                int gray = (r + g + b) / 3;
                Color c = new Color(gray, gray, gray);
                this.bufferedImage.setRGB(i, j, c.getRGB());
            }


        }

    }

    public void invertColors() {
        for (int i = 0; i < this.bufferedImage.getWidth(); i++) {
            for (int j = 0; j < this.bufferedImage.getHeight(); j++) {
                Color color = new Color(this.bufferedImage.getRGB(i, j));
                int r = 255 - color.getRed();
                int g = 255 - color.getGreen();
                int b = 255 - color.getBlue();
                int a = color.getAlpha();
                Color invertedColor = new Color(r, g, b, a);
                this.bufferedImage.setRGB(i, j, invertedColor.getRGB());
            }
        }
    }










}

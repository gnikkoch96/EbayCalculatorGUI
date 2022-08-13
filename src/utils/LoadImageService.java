package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadImageService{
    public static JLabel loadImage(String fileName){
        BufferedImage bImage;
        JLabel imageLabel;

        try{
            bImage = ImageIO.read(new File("D:\\Programming Related\\Java Projects\\EbayCalculator\\src\\resources\\logo.png"));
            imageLabel = new JLabel(new ImageIcon(bImage));

            return imageLabel;
        }catch(IOException e){
            System.out.println("ERROR: Failed to Load Image: " + e);
            return null;
        }
    }
}

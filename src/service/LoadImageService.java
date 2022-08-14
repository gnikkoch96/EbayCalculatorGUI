package service;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 *  Note: place images in the resource folder
 */
public class LoadImageService{
    public static JLabel loadImage(String fileName){
        BufferedImage bImage;
        JLabel imageLabel;

        try{
            String filePath = "src/resources/" + fileName;
            bImage = ImageIO.read(new File(filePath));
            imageLabel = new JLabel(new ImageIcon(bImage));

            return imageLabel;
        }catch(IOException e){
            System.out.println("ERROR: Failed to Load Image: " + e);
            return null;
        }
    }
}

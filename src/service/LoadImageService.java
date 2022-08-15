package service;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/*
 *  Note: place images in the resource folder
 */
public class LoadImageService{
    public static JLabel loadImage(String fileName){
        BufferedImage bImage;
        JLabel imageLabel;

        try{
            String filePath = "resources/" + fileName;
            InputStream inputStream = LoadImageService.class.getResourceAsStream(filePath);

            if(inputStream == null){
                inputStream = LoadImageService.class.getClassLoader().getResourceAsStream(filePath);
            }

            bImage = ImageIO.read(inputStream);

            imageLabel = new JLabel(new ImageIcon(bImage));

            return imageLabel;
        }catch(Exception e){
            System.out.println("ERROR: Failed to Load Image: " + e);
            return null;
        }
    }
}

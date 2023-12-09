/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gfx;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
    public static Image loadImage(String filePath) {
        try {
            return ImageIO.read(ImageUtils.class.getResource(filePath));
        } catch (IOException e ) {
            System.out.println("Could not load image from path: " + filePath);
        }
        
        return null;
    }
}

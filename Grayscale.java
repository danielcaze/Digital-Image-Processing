/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imageeditor;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author danie
 */
public class Grayscale {
    public static BufferedImage grayRed (BufferedImage image) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage grayscaleR = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                    int rgb = image.getRGB(col, lin);
                    Color cor = new Color(rgb);
                    int red = cor.getRed();
                    Color vermelhoApenas = new Color(red, red, red);
                    grayscaleR.setRGB(col, lin, vermelhoApenas.getRGB());
             }
        }
			 
        return grayscaleR;
    }
		
		
    public static BufferedImage grayGreen (BufferedImage image) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage grayscaleG = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int green = cor.getGreen();
                Color verdeApenas = new Color(green, green, green);
                grayscaleG.setRGB(col, lin, verdeApenas.getRGB());
             }
        }

        return grayscaleG;
    }
		
		
    public static BufferedImage grayBlue (BufferedImage image) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage grayscaleB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                Color azulApenas = new Color(blue, blue, blue);
                grayscaleB.setRGB(col, lin, azulApenas.getRGB());
             }
        }

        return grayscaleB;

    }
    
    public static BufferedImage grayRGB (BufferedImage image) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage grayscaleRGB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red+green+blue)/3;
                Color azulApenas = new Color(media, media, media);
                grayscaleRGB.setRGB(col, lin, azulApenas.getRGB());
             }
        }

        return grayscaleRGB;


    }
}

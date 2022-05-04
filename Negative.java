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
public class Negative {
    public static BufferedImage negative (BufferedImage image) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage negativeFilter = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color azulApenas = new Color(255 - red, 255 - green, 255 - blue);
                negativeFilter.setRGB(col, lin, azulApenas.getRGB());
             }
        }	 
        return negativeFilter;
    }	
}

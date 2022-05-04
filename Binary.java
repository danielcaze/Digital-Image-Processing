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
public class Binary {
    public static BufferedImage binary (BufferedImage image, int limiar) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage binaryFilter = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red+green+blue)/3;
                int calculo = calcularLimiar(media, limiar);
                Color azulApenas = new Color(calculo, calculo, calculo);
                binaryFilter.setRGB(col, lin, azulApenas.getRGB());
             }
        }

        return binaryFilter;
    }
    
    public static int calcularLimiar (int atual, int limiar) {
        if (atual <= limiar)
            atual = 0;
        else if(atual > limiar)
            atual = 255;
        return atual;
    }		
}

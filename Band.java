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
public class Band {
    
    public static BufferedImage allRed (BufferedImage image, int valor) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage imagemsaidaR = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                int calculo = calcularTom(red, valor);
                Color vermelhoApenas = new Color(calculo, 0, 0);
                imagemsaidaR.setRGB(col, lin, vermelhoApenas.getRGB());
            }
        }

        return imagemsaidaR;
    }
         
		
		
    public static BufferedImage allGreen (BufferedImage image, int valor) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage imagemsaidaG = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int green = cor.getGreen();
                int calculo = calcularTom(green, valor);
                Color verdeApenas = new Color( 0, calculo, 0);
                imagemsaidaG.setRGB(col, lin, verdeApenas.getRGB());
            }
        }
			 
        return imagemsaidaG;
    }
	
    public static BufferedImage allBlue(BufferedImage image, int valor) {
        int altura = image.getHeight();
        int largura = image.getWidth();
        BufferedImage allBlue = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int lin = 0; lin < altura; lin++) {
            for (int col = 0; col < largura; col++) {
                int rgb = image.getRGB(col, lin);
                Color cor = new Color(rgb);
                int blue = cor.getBlue();
                int calculo = calcularTom(blue, valor);
                Color azulApenas = new Color(0, 0, calculo);
                allBlue.setRGB(col, lin, azulApenas.getRGB());
            }  
        }
        return allBlue;
			 
    }
                
    public static int calcularTom (int quantidade, int aumento) {
        if (quantidade + aumento > 255)
            aumento = 255;
        else if(quantidade + aumento < 0)
            aumento = 0;
        else 
            aumento += quantidade;
        return aumento;
    }		
}

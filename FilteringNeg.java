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
public class FilteringNeg {
    public double[][][] RGBtoYIQ (BufferedImage image){

		int largura = image.getWidth();
		int altura = image.getHeight();
		double[][][] imageYIQ = new double[altura][largura][3];

		for(int linha=0; linha < altura; linha++){
			for(int coluna = 0; coluna < largura; coluna++){

				int rgb = image.getRGB(coluna,linha);
				Color cor = new Color(rgb);
				int red = cor.getRed();
				int green = cor.getGreen();
				int blue = cor.getBlue();

				imageYIQ[linha][coluna][0] = (double) (0.299 * red + 0.587 * green + 0.114 * blue); //Y
				imageYIQ[linha][coluna][1]= (double) (0.596 * red - 0.274 * green - 0.322 * blue); //I
				imageYIQ[linha][coluna][2] = (double) (0.211 * red - 0.523 * green + 0.312 * blue); //Q
			}
		 }	
		 return imageYIQ;
	}
	
	public BufferedImage YIQtoRGB (double[][][] imageYIQ) {
		int altura = imageYIQ.length;
		int largura = imageYIQ[0].length;
		
		BufferedImage imgSaida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
		
		for (int linha = 0; linha < altura; linha++) {
			for (int coluna = 0; coluna < largura; coluna++) {
				
				double y = 255 - imageYIQ[linha][coluna][0];
				double i = imageYIQ[linha][coluna][1];
				double q = imageYIQ[linha][coluna][2];
				
				
				int red = (int) (y + 0.956 * i + 0.621 * q);
				int green = (int) (y - 0.272 * i - 0.647 * q);
				int blue = (int) (y - 1.106 * i + 1.703 * q);

				if (red > 255) red = 255;
				else if (red < 0) red = 0;			
				
				if (green > 255) green = 255;
				 else if (green < 0) green = 0;
				
				if (blue > 255) blue = 255;
				 else if (blue < 0) blue = 0;
				
				
				Color novaCor = new Color(red, green, blue);
				imgSaida.setRGB(coluna, linha, novaCor.getRGB());
			}
		 }
		
		
		return imgSaida;
	}
		
}

package Editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageEditor {

	public static void main(String[] args)throws IOException {
					
		File f = null;		
		f = new File("C:\\Users\\danie\\Pictures\\renato.jpg");
			 		
		BufferedImage image = ImageIO.read(f);
					
			
		
		BufferedImage grayscaleR = grayRed(image);		
		BufferedImage grayscaleG = grayGreen(image);		
		BufferedImage grayscaleB = grayBlue(image);	 		
		BufferedImage grayscaleRGB = grayRGB(image);
				
		BufferedImage negativeFilter = negative(image);
		
		 int altura = image.getHeight();
		 int largura = image.getWidth();
		 //System.out.printf("\nlargura = %d", largura);
		 //System.out.printf("\naltura = %d\n", altura);
		 
		 Color azul = new Color (0,0,255);
		 Color verde = new Color (0,255,0);
		 Color vermelho = new Color (255,0,0);
		
		 image.setRGB(0, 0, azul.getRGB());
		 image.setRGB(largura/2, altura/2, verde.getRGB());
		 image.setRGB(largura-1, altura-1, vermelho.getRGB());
		 
		 for (int lin = 0; lin < altura; lin++) {
		 	for (int col = 0; col < largura; col++) {
		 		Color C = new Color(image.getRGB(col,lin));
		 		int R = C.getRed();
		 		int G = C.getGreen();
		 		int B = C.getBlue();
		 		//System.out.println("[LINHA: " + lin + "] [COLUNA: " + col +"] Vermelho: " + R + " Verde: " + G + " Azul: " + B);
			  }
			}
		 
		 ImageIO.write(image, "jpg", new File("C:\\Users\\danie\\Pictures\\renato-deus.jpg"));
		 	 


		System.out.println("Digite qual filtro deseja usar:"+"\n[1] - Banda "+"\n[2] - Grayscale "+"\n[3] - Negativo"+"\n[9] - Sair");	
		System.out.print("->");
		Scanner teclado1 = new Scanner(System.in);		
		int filtro = teclado1.nextInt();		 
		
		if (filtro == 1) {
			
			System.out.println("Você deseja mudar a tonalidade da imagem? \n [1] - Sim | [2] - Não");
			System.out.print("->");
			Scanner teclado2 = new Scanner(System.in);			
			int escolhaTom = teclado2.nextInt();	
			if(escolhaTom == 1) {
				
				System.out.println("Digite em qual banda deseja aplicar o tom:  \n[1] - Vermelho | [2] - Verde | [3] - Blue");
				System.out.print("->");
				Scanner teclado3 = new Scanner(System.in);			
				int banda1 = teclado3.nextInt();		
				
				System.out.println("Digite o valor do tom que quer aplicar: \nUtilize valores de -255 a 255");	
				System.out.print("->");
				Scanner teclado4 = new Scanner(System.in);				
				int valor = teclado4.nextInt();	
				
				BufferedImage imagemsaidaR = allRed(image, valor);		
				BufferedImage imagemsaidaG = allGreen(image, valor);		
				BufferedImage imagemsaidaB = allBlue(image, valor);
			    
				 switch(banda1) {
				 	
				 	case 1:
				 		JLabel mylabel2 = new JLabel(new ImageIcon(imagemsaidaR));
				 		JPanel mypanel2 = new JPanel();
				 		mypanel2.add(mylabel2);
				 		JFrame myframe2 = new JFrame();
				 		myframe2.setSize(new Dimension(largura, altura));
				 		myframe2.add(mypanel2);
				 		myframe2.setVisible(true);
				 		break;

				 	case 2:
				 		JLabel mylabel3 = new JLabel(new ImageIcon(imagemsaidaG));
				 		JPanel mypanel3 = new JPanel();
				 		mypanel3.add(mylabel3);
						JFrame myframe3 = new JFrame();
						myframe3.setSize(new Dimension(largura, altura));
						myframe3.add(mypanel3);
						myframe3.setVisible(true);
						break;

				 	case 3:
				 		JLabel mylabel4 = new JLabel(new ImageIcon(imagemsaidaB));
				 		JPanel mypanel4 = new JPanel();
				 		mypanel4.add(mylabel4);
				 		JFrame myframe4 = new JFrame();
				 		myframe4.setSize(new Dimension(largura, altura));
				 		myframe4.add(mypanel4);
				 		myframe4.setVisible(true);
				 		break;
				 	default:
				 		System.out.println("Digite um número válido");
				 		break;
				 }
				 teclado2.close();
				 teclado3.close();
				 teclado4.close();
			}

			else if (escolhaTom == 2) {
				int valor = 0;
				System.out.println("Qual banda deseja visualizar? \n [1] - Red | [2] - Green | [3] - Blue");	
				System.out.print("->");
				Scanner teclado5 = new Scanner(System.in);			
				int banda1 = teclado5.nextInt();		
				
				BufferedImage imagemsaidaR = allRed(image, valor);		
				BufferedImage imagemsaidaG = allGreen(image, valor);		
				BufferedImage imagemsaidaB = allBlue(image, valor);
				
				 switch(banda1) {

				 	case 1:
				 		JLabel mylabel2 = new JLabel(new ImageIcon(imagemsaidaR));
				 		JPanel mypanel2 = new JPanel();
				 		mypanel2.add(mylabel2);
				 		JFrame myframe2 = new JFrame();
				 		myframe2.setSize(new Dimension(largura, altura));
				 		myframe2.add(mypanel2);
				 		myframe2.setVisible(true);
				 		break;

				 	case 2:
				 		JLabel mylabel3 = new JLabel(new ImageIcon(imagemsaidaG));
				 		JPanel mypanel3 = new JPanel();
				 		mypanel3.add(mylabel3);
						JFrame myframe3 = new JFrame();
						myframe3.setSize(new Dimension(largura, altura));
						myframe3.add(mypanel3);
						myframe3.setVisible(true);
						break;
						
				 	case 3:
				 		JLabel mylabel4 = new JLabel(new ImageIcon(imagemsaidaB));
				 		JPanel mypanel4 = new JPanel();
				 		mypanel4.add(mylabel4);
				 		JFrame myframe4 = new JFrame();
				 		myframe4.setSize(new Dimension(largura, altura));
				 		myframe4.add(mypanel4);
				 		myframe4.setVisible(true);
				 		break;
				 	default:
				 		System.out.println("Digite um número válido");
				 		break;
				 }
				 teclado5.close();
			}
				


					

			 
		 } else if(filtro == 2) {
			 System.out.println("Qual tipo de Grayscale deseja usar? \n[1] - Grayscale Banda"+"\n[2] - Grayscale RGB");
			 System.out.print("->");
			 Scanner teclado6 = new Scanner(System.in);
			 int grayscale = teclado6.nextInt();
			 
			 if(grayscale == 1) {
				 System.out.println("Em qual banda deseja aplicar o Grayscale? \n[1] - Vermelho | [2] - Verde | [3] - Blue");
				 System.out.print("->");
				 Scanner teclado7 = new Scanner(System.in);
				 int banda2 = teclado7.nextInt();
				 
				 switch(banda2) {
				 	
				 	case 1:
				 		JLabel mylabel2 = new JLabel(new ImageIcon(grayscaleR));
				 		JPanel mypanel2 = new JPanel();
				 		mypanel2.add(mylabel2);
				 		JFrame myframe2 = new JFrame();
				 		myframe2.setSize(new Dimension(largura, altura));
				 		myframe2.add(mypanel2);
				 		myframe2.setVisible(true);
				 		break;

				 	case 2:
				 		JLabel mylabel3 = new JLabel(new ImageIcon(grayscaleG));
				 		JPanel mypanel3 = new JPanel();
				 		mypanel3.add(mylabel3);
						JFrame myframe3 = new JFrame();
						myframe3.setSize(new Dimension(largura, altura));
						myframe3.add(mypanel3);
						myframe3.setVisible(true);
						break;

				 	case 3:
				 		JLabel mylabel4 = new JLabel(new ImageIcon(grayscaleB));
				 		JPanel mypanel4 = new JPanel();
				 		mypanel4.add(mylabel4);
				 		JFrame myframe4 = new JFrame();
				 		myframe4.setSize(new Dimension(largura, altura));
				 		myframe4.add(mypanel4);
				 		myframe4.setVisible(true);
				 		break;
				 	default:
				 		System.out.println("Digite um número válido");
				 		break;
				 }
				 teclado6.close();
				 teclado7.close();
			 } else if (grayscale == 2) {
				 JLabel myLabelGrayscaleRGB = new JLabel(new ImageIcon(grayscaleRGB));
				 JPanel myPanelGrayscaleRGB = new JPanel();
				 myPanelGrayscaleRGB.add(myLabelGrayscaleRGB);
				 JFrame myFrameGrayscaleRGB = new JFrame();
				 myFrameGrayscaleRGB.setSize(new Dimension(largura, altura));
				 myFrameGrayscaleRGB.add(myPanelGrayscaleRGB);
				 myFrameGrayscaleRGB.setVisible(true);
				 teclado6.close();
			 } else {
				 System.out.println("Digite o tipo de Grayscale corretamente");
			 } 
			 
		 } else if (filtro == 3) {
			 JLabel myLabelNegative = new JLabel(new ImageIcon(negativeFilter));
			 JPanel myPanelNegative = new JPanel();
			 myPanelNegative.add(myLabelNegative);
			 JFrame myFrameNegative = new JFrame();
			 myFrameNegative.setSize(new Dimension(largura, altura));
			 myFrameNegative.add(myPanelNegative);
			 myFrameNegative.setVisible(true);
			 
		 } else {
			 System.out.println("Você viu esse numero em algum lugar?");
		 }
		 
		 JLabel myLabelNormal = new JLabel(new ImageIcon(image));
		 JPanel myPanelNormal = new JPanel();
		 myPanelNormal.add(myLabelNormal);
		 JFrame myFrameNormal = new JFrame();
		 myFrameNormal.setSize(new Dimension(largura, altura));
		 myFrameNormal.add(myPanelNormal);
		 myFrameNormal.setVisible(true);
		 
		teclado1.close();
		}
				 
	
			
		public static BufferedImage allRed (BufferedImage image,int valor) {
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

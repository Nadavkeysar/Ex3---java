package ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class Ex3 {

	// Function that receives RGB image and converts it to greyscale

	public static int[][] rgb2gray(int[][][] im){
		int temp [][] = new int[im[0].length][im[0][0].length];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int R = im[0][i][j];
				int G = im[1][i][j];
				int B= im[2][i][j];

				temp[i][j] =(int)((Math.floor((0.3*R+0.59*G+0.11*B)))*255);
			}
		}

		return temp;
	}

	// Function that receives a 3D RGB image and an integer and returns the image in single color channel

	public static int[][][] channels(int[][][] im, int n ){
		int len = im.length;
		int wLen =im[0].length;
		int hLen =im[0][0].length;

		int temp [][][] = new int[len][wLen][hLen];

		for (int i = 0; i < wLen; i++) {

			for (int j = 0; j < hLen; j++) {

				int R = im[0][i][j];
				int G = im[1][i][j];
				int B = im[2][i][j];

				if (n==0) {
					temp[0][i][j] = R;
				}
				else if (n==1) {

					temp[1][i][j] = G;

				}
				else{
					temp[2][i][j] = B;
				}

			}
		}
		return temp;

	}

	// Receives a 3D image in RGB array and converts it to a sorted histogram
	// includes a function for sorting a 2D array
	public static int [][] histogram(int [][][] img){
		int [][] histogram1= new int [3][256];
		int temp;
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				for (int k = 0; k < img[0][0].length; k++) {
					histogram1[i][img[i][j][k]]++;
				}
			}
		}

		for (int i = 0; i < histogram1.length; i++) {
			for (int j = 0; j < histogram1[0].length; j++) {
				for (int k = 0; k < histogram1[0].length-1; k++) {
					if (histogram1[i][k] > histogram1[i][k+1]) {
						temp = histogram1[i][k];
						histogram1[i][k] = histogram1[i][k+1];
						histogram1[i][k+1] = temp;
					}
				}
			}
		}
		return histogram1;
	}



	// Receives a 3D image array as RGB and an integer and pixelate the image in the factor n

	public static int[][][] pix(int[][][] im, int n){
		double P=255/n;

		for (int i = 0; i < im.length; i++) {
			for (int j = 0; j < im[0].length; j++) {
				for (int k = 0; k < im[0][0].length-1; k++) {
					double temp1=im[i][j][k];
					double temp2=temp1/P;
					double temp3=(Math.ceil(temp2));
					im[i][j][k]=(int)temp3;
				}
			}
		}
		return im;
	}

	public static void main(String[] args) {
		//	int [][][] image= readImageFromFile("C:\Users\HP\Pictures\1.jpg");
		//	int [][] res= rgb2gray(image);
		//	writeImageToFile("C:\Users\HP\Pictures\cat", res);
		//int [][] res=histogram(MyImageIO.readImageFromFile("C:/Users/HP/Pictures/1.jpg"));
		//System.out.println(Arrays.deepToString(histogram(MyImageIO.readImageFromFile("C:/Users/HP/Pictures/1.jpg"))));
	}


}

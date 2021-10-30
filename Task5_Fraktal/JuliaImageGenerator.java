package Task5_Fraktal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class JuliaImageGenerator extends Thread {
	final static int N = 4096;
	final static int CUTOFF = 100;
	static int[][] set = new int[N][N];
	
	public static void main(String[] args) throws Exception {
		
		long startTime = System.currentTimeMillis();
		
		JuliaImageGenerator thread0 = new JuliaImageGenerator(0);
		JuliaImageGenerator thread1 = new JuliaImageGenerator(1);
		JuliaImageGenerator thread2 = new JuliaImageGenerator(2);
		JuliaImageGenerator thread3 = new JuliaImageGenerator(3);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		thread0.join();
		thread1.join();
		thread2.join();
		thread3.join();
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("Obliczenia zakonczone w czasie " + (endTime - startTime) + " millisekund");
		
		BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int k = set[i][j];
				float level;
				if (k < CUTOFF) {
					
					level = (float) k / CUTOFF;
				}else {
					level = 0;
				}
				// 1) red 3) blue
				Color c = new Color(0, 0, level);  
				img.setRGB(i, j, c.getRGB());
			}
		}
		ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_crystal.png"));
		/*
		ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_snowflake.png"));
		ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_8.png"));
		ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_koronawirus.png"));
		ImageIO.write(img, "PNG", new File("src/resources/julia/Julia_spirall.png"));
		*/
	}
		
	int me;
	public JuliaImageGenerator(int me) {
		this.me = me;
	}
	
	public void run() {
		int begin = 0, end = 0;
		if (me == 0) {
			begin = 0;
			end = (N / 4) * 1;
		}
		else if (me == 1) {
			begin = (N / 4) * 1;
			end = (N / 4) * 2;
		}
		else if (me == 2) {
			begin = (N / 4) * 2;
			end = (N / 4) * 3;
		} 
		else if (me == 3) { 
			begin = (N / 4) * 3;
			end = N;
		}
		//pick some values for the constant c, this determines the shape of the Julia Set
		// snowflake
		/*
		double cRe = -0.70176;
		double cIm = -0.3842;
		*/
		// 8
		/*
		double cRe = 0.285;
		double cIm = 0.01;
		*/
		// koronawirus
		/*
		double cRe = -0.8;
		double cIm = 0.156;
		*/
		// crystal
		/**/
		double cRe = -0.62772;
		double cIm = 0.42193;
		
		// spirall
		/*
		double cRe = -0.7709787;
		double cIm = 0.08545;
		*/
		
		for (int i = begin; i < end; i++) {
			for (int j = 0; j < N; j++) {
				double cr = (4.0 * i - 2 * N) / N;
				double ci = (4.0 * j - 2 * N) / N;
				double zr = cr, zi = ci;
				int k = 0;

				while (k < CUTOFF && zr * zr + zi * zi < 4.0) {
					double newr = zr*zr - zi*zi + cRe;
					double newi = 2*zr*zi + cIm;
					zr = newr;
					zi = newi;
					k++;
				}
				set[i][j] = k;	
			}
		}
	}
}




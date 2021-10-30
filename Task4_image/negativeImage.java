package Task4_image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class negativeImage extends Thread {
	BufferedImage image;
	static int width;
	static int height;
	private ArrayList<Pixel> pixsels = new ArrayList<>(); 
	private static String path = "src/resources/giu.jpg";
	
	int numer;
	public negativeImage(int numer) {
		this.numer = numer;
	}
	
	public ArrayList<Pixel> getPexel(){
		return pixsels;
	}
	
	public static String getPath() {
		return path;
	}
	
	public void run() {
		try {
			
			File input = new File(path);
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			
			int begin_i = 1, end_i = 1;
			int begin_j = 1, end_j = 1;
			if (numer == 0) {
				begin_i = 1;
				end_i = height/2;
				begin_j = 1;
				end_j = width/2;
			}
			else if (numer == 1) {
				begin_i = 1;
				end_i = height/2;
				begin_j = width/2;
				end_j = width;
			}
			else if (numer == 2) {
				begin_i = height/2;
				end_i = height;
				begin_j = 1;
				end_j = width/2;
			} 
			else if (numer == 3) { 
				begin_i = height/2;
				end_i = height;
				begin_j = width/2;
				end_j = width;
			}
			 
			for(int i = begin_i; i < end_i; i++){
				for(int j = begin_j; j < end_j; j++){
					 
					 Color c = new Color(image.getRGB(j, i));
					 int red = (int)(c.getRed());
					 int green = (int)(c.getGreen());
					 int blue = (int)(c.getBlue());
					 
					 int final_red, final_green, final_blue;
					 
					 final_red = 255-red;
					 final_green = 255-green;
					 final_blue = 255-blue;
					 Color newColor = new Color(final_red, final_green, final_blue);
					 pixsels.add(new Pixel(j, i, newColor));
					 
				} 
			}
		} catch (Exception e) {}
	}
	
}

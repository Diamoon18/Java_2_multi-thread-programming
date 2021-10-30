package Task4_image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class main {

	public static void main(String[] args) throws InterruptedException {
		negativeImage thread0 = new negativeImage(0);
		negativeImage thread1 = new negativeImage(1);
		negativeImage thread2 = new negativeImage(2);
		negativeImage thread3 = new negativeImage(3);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread0.join();
		thread1.join();
		thread2.join();
		thread3.join();
		
		ArrayList <Pixel> res_p = new ArrayList<>();
		res_p.addAll(thread0.getPexel());
		res_p.addAll(thread1.getPexel());
		res_p.addAll(thread2.getPexel());
		res_p.addAll(thread3.getPexel());
		
		BufferedImage image;
		String path = negativeImage.getPath();
	
		try {
			File input = new File(path);
			image = ImageIO.read(input);
			
			for(Pixel p : res_p) {
				image.setRGB(p.getJ(), p.getI(), p.getColor().getRGB());
			}

			File ouptut = new File(path.replace(".jpg", "_negative.jpg"));
			ImageIO.write(image, "jpg", ouptut);
		} catch (Exception e) {}
	}

}

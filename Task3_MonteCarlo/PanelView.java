package Task3_MonteCarlo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class PanelView {
	
	public static boolean click = false;
	public Button start_button = new Button(45, 330, 400, 45,"START SIMULATION");
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,  0, Application.WIDTH, Application.HEIGHT);
		
        g2d.drawImage(imagesLoad.start_image, 0, 40, null);
        
		start_button.setSizeF(35);
		start_button.draw(g2d);
	}
}

package Task1_timepiece;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PanelView {
	static Image cat= new ImageIcon("src/Resources/cat.gif").getImage();
	
	public void draw(Graphics g, String time) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(cat, 0, 0, null);
		
		g2d.setColor(new Color(251, 132, 171));
		Font font = new Font("Arial", Font.BOLD, 45);
		g.setFont(font);
		g2d.drawString(time, 120, 150);
		
	}
}
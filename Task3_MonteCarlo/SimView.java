package Task3_MonteCarlo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SimView {
	public static boolean click = false;
	private ArrayList<Punkt> p = new ArrayList<>();
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,  0, Application.WIDTH, Application.HEIGHT);
		
		g2d.setColor(Color.BLUE.brighter());
		g2d.setStroke(new BasicStroke(10));
		g2d.drawOval(0, 0, 470, 470);
		g2d.setStroke(new BasicStroke(1));
		
		g2d.setColor(Color.WHITE);
		p = SimModel.getPoints();
		for(Punkt pn: p) {
			g2d.fillOval(pn.getX(), pn.getY(), 2, 2);
		}
		p.clear();
	}
}

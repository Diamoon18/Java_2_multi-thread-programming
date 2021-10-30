package Task1_timepiece;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private Graphics2D g;
	
	private static String TIME = "1";
	
	Timer mainTimer = new Timer(50, this);
	Czasomierz cz;
	PanelView pv;
	
	public Panel() {
		initPanel();
	}
	
	private void initPanel() {
        setFocusable(true);
        requestFocus();
        mainTimer.start();
        
        image = new BufferedImage(Application.WIDTH, Application.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        
        pv = new PanelView();
        cz = new Czasomierz(23, 59, 0);
        cz.start();
	}
	
	private void draw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (TIME.equals("1")){
			pv.draw(g, cz.time);
			draw();
		}
	}
}



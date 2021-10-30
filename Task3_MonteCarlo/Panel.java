package Task3_MonteCarlo;

import java.awt.Color;
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
	
	public static StateEnum state = StateEnum.START;
	
	public static int mouseX;
	public static int mouseY;
	
	
	Timer mainTimer = new Timer(50, this);
	PanelView pv;
	SimView sv;
	
	private Color color_change = new Color(153, 106, 37);
	private Color color_base = Color.WHITE;
	
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
        sv = new SimView();
        
        addMouseListener(new panelController());
        addMouseMotionListener(new panelController());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (state.equals(StateEnum.START)){
			pv.draw(g);
			draw();
			try {
				pasteButton(pv.start_button);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (state.equals(StateEnum.SIM)){
			sv.draw(g);
			draw();	
			questionForm.frame_result(SimModel.getResult());
		}
	}
	
	private void pasteButton(Button e) throws InterruptedException {
		if (mouseX > e.getX() && mouseX < e.getX()+e.getW() &&
				mouseY > e.getY() && mouseY < e.getY()+e.getH()) {
			if(e.equals(pv.start_button)) {
				e.color1 = color_change;
				if (pv.click) {
					questionForm.frame_points();
					state = state.SIM;
					pv.click = false;
				}
			}
		} else {
			if(e.equals(pv.start_button)) {e.color1 = color_base;}
		}
	}
	
	private void draw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}

}

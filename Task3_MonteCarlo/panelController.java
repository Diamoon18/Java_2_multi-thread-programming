package Task3_MonteCarlo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class panelController implements MouseListener, MouseMotionListener{

	public panelController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		PanelView.click = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		PanelView.click = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Panel.mouseX = e.getX();
		Panel.mouseY = e.getY();
	}

}

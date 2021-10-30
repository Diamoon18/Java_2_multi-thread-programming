package Task1_timepiece;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;
	
    
    public Application() {
    	initUI();
    }

    private void initUI() {
    	add(new Panel());
        setSize(WIDTH, HEIGHT);

        setTitle("Timepiece - cat");
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
       
    }    
    
    public static void main(String[] args) {
    	 EventQueue.invokeLater(() -> {
             Application ex = new Application();
             ex.setVisible(true);
         });
       
    }
}

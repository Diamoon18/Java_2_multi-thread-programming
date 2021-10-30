package Task3_MonteCarlo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class questionForm{
	
	private static int points;
	static JFrame f;

	public static void frame_points() throws InterruptedException {
		f = new JFrame();
		String input = "1";
		input = JOptionPane.showInputDialog( "Amount of points from 31:");
		if(input == null || input.isEmpty() || !input.matches("[1-9][0-9]*")) {
			input = "100";
			JOptionPane.showMessageDialog(f,"Error input, default input 100");
		}
		points = Integer.parseInt(input);
		if(points < 30) {
			points = 100;
			JOptionPane.showMessageDialog(f,"Error input, default input 100");
		}
		SimModel.threads_start(points);
	}
	
	public static void frame_result(double result){
		f = new JFrame();
		
		int res = JOptionPane.showConfirmDialog(f,"Result: " + result + "\nYou want to exit?", "Success",
	               JOptionPane.YES_NO_OPTION,
	               JOptionPane.QUESTION_MESSAGE);
        if(res == JOptionPane.YES_OPTION){
        	System.exit(0);
        }else if (res == JOptionPane.NO_OPTION){
            Panel.state = StateEnum.START;
        }
	}
	
	public static double getPoints() {
		return points;
	}
}

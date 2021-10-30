package Task3_MonteCarlo;

import java.util.ArrayList;
import java.util.Random;

public class MonteCarlo extends Thread {
	private static int sum_points;
	private ArrayList<Punkt> points = new ArrayList<>();
	private Random rand;
	private int result;
	int pointX, pointY;
	
	private int numer;
	
	public MonteCarlo(int numer) {
		this.numer = numer;
	}
	
	public static void setSumPoints(int sum_points) {
		MonteCarlo.sum_points = sum_points;
	}
	
	public ArrayList<Punkt> getPoints(){
		return points;
	}
	
	public int getResult() {
		return result;
	}
	
	public void run() {
		int begin_x = 1, end_x = 1;
		int begin_y = 1, end_y = 1;
		// x[1; 235]y[1;235]
		if (numer == 0) {
			begin_x = 1;
			end_x = 235;
			begin_y = 1;
			end_y = 235;
		}
		// x[1; 235]y[235;470]
		else if (numer == 1) {
			begin_x = 1;
			end_x = 235;
			begin_y = 235;
			end_y = 470;
		}
		// x[235;470]y[1; 235]
		else if (numer == 2) {
			begin_x = 235;
			end_x = 470;
			begin_y = 1;
			end_y = 235;
		} 
		// x[235;470]y[235;470]
		else if (numer == 3) { 
			begin_x = 235;
			end_x = 470;
			begin_y = 235;
			end_y = 470;
		}
		rand = new Random();
		
		for(int i = 0; i <= sum_points; i++){
			pointX = rand.nextInt(end_x-begin_x) + begin_x; 
			pointY = rand.nextInt(end_y-begin_y) + begin_y;
			// System.out.println(new Punkt(pointX, pointY));
			points.add(new Punkt(pointX, pointY));
			if (Math.sqrt((pointX - 470) * (pointX - 470) + (pointY - 470) * (pointY - 470)) <= 235) {
				result++;
			}     
		}
			
	}

}
 
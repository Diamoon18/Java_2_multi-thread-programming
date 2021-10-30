package Task3_MonteCarlo;

import java.util.ArrayList;

public class SimModel {
	private static ArrayList<Punkt> result_p = new ArrayList<>();
	private static double result = 0;
	
	public static ArrayList<Punkt> getPoints(){
		return result_p;
	}
	
	public static double getResult() {
		return result;
	}
	
	public static void threads_start(int sum_points) throws InterruptedException {
		MonteCarlo.setSumPoints(sum_points);
		
		MonteCarlo thread0 = new MonteCarlo(0);
		MonteCarlo thread1 = new MonteCarlo(1);
		MonteCarlo thread2 = new MonteCarlo(2);
		MonteCarlo thread3 = new MonteCarlo(3);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread0.join();
		thread1.join();
		thread2.join();
		thread3.join();
		
		result_p.addAll(thread0.getPoints());
		result_p.addAll(thread1.getPoints());
		result_p.addAll(thread2.getPoints());
		result_p.addAll(thread3.getPoints());
		
		result = thread0.getResult() + thread1.getResult() + 
				thread2.getResult() + thread3.getResult();
		result = (result*Math.pow(470, 2))/sum_points;
	}
}

package Task6_Filozof;

import java.util.concurrent.Semaphore;

public class Filozof_1 extends Thread {
	static int MAX;
	static Semaphore [] widelec;
	int mojNum;
	
	public Filozof_1 (int nr) {
		mojNum = nr;
	}
	
	public void run() {
		while(true) {
			// myslenie
			System.out.println("Mysle ¦ " + mojNum);
			try {
				Thread.sleep((long)(7000 * Math.random()));
			} catch (InterruptedException e){}
			widelec[mojNum].acquireUninterruptibly(); // przechwycenie L widelca
			widelec[(mojNum+1)%MAX].acquireUninterruptibly(); // przechwycenie P widelca
			// jedzenie 
			System.out.println ("Zaczyna jesc " + mojNum);
			try {
				Thread.sleep((long)(5000 * Math.random()));
			} catch (InterruptedException e) {}
			System.out.println ("Konczy jesc "+ mojNum) ;
			widelec[mojNum].release(); // zwolnienie L widelca
			widelec[(mojNum+1)%MAX].release(); // zwolnienie P widelca
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < MAX; i++) {
			widelec[i] = new Semaphore(1) ;
		}
		for ( int i =0; i < MAX; i++) {
			new Filozof_1(i).start();
		}
	}
}


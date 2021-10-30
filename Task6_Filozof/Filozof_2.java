package Task6_Filozof;

import java.util.concurrent.Semaphore ;
public class Filozof_2 extends Thread {
	static int MAX;
	static Semaphore [] widelec;
	int mojNum;
	
	public Filozof_2(int nr) {
		mojNum = nr;
	}
	
	public void run(){
		while(true) {
			// myslenie
			System.out.println ( "Mysle ¦ " + mojNum) ;
			try {
				Thread.sleep ((long)(5000 * Math.random())) ;
			} catch (InterruptedException e) {}
			if (mojNum == 0) {
				widelec[(mojNum+1)%MAX].acquireUninterruptibly();
				widelec[mojNum].acquireUninterruptibly();
			} else {
				widelec [mojNum].acquireUninterruptibly();
				widelec [(mojNum+1)%MAX].acquireUninterruptibly();
			}
			// jedzenie
			System.out.println ( "Zaczyna jesc "+ mojNum);
			try {
				Thread.sleep ((long)(3000 * Math.random()));
			} catch ( InterruptedException e ) {}
			System.out.println ( "Konczy jesc "+ mojNum) ;
			widelec [mojNum].release();
			widelec [(mojNum+1)%MAX].release();
		}
	}
	
	public static void main ( String [] args ) {
		for(int i = 0; i < MAX; i++) {
			widelec[i] = new Semaphore(1);
		}
		for(int i =0; i < MAX; i++) {
			new Filozof_2(i).start();
		}
	}
}

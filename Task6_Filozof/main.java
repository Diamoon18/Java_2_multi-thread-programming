package Task6_Filozof;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class main {
	
	private static String opcja;
	
	public static void main(String[] args) {
		menu();
	}

	static public void menu() {
		
		System.out.println("---Problem 5 filozofow---");
		System.out.println("Wybierz opcje 1-4");
		System.out.println("1. Standartowa implementacja.");
		System.out.println("2. Implementacja z niesymetrycznym sieganiem po widelce.");
		System.out.println("3. Rzut monety w rozwiazaniu problemu ucztujacych Filozofow.");
		System.out.println("4. Wyjscie");
		
		Scanner scan = new Scanner(System.in);
		opcja = scan.next();
		while(sprawdzOpcje(opcja)) {
			System.out.println("Error! Wybierz opcje 1-4");
			opcja = scan.next();
		}
		
		switch(opcja){
		  case "1":
			System.out.println("Nr-1 Start!");
		    Filozof_1.MAX = setNumFiloz();
		    Filozof_1.widelec = new Semaphore[Filozof_1.MAX];
		    for(int i = 0; i < Filozof_1.MAX; i++) {
		    	Filozof_1.widelec[i] = new Semaphore(1);
			}
			for (int i = 0; i < Filozof_1.MAX; i++) {
				new Filozof_1(i).start();
			}
		    break;
		  case "2":
			System.out.println("Nr-2 Start!");
			Filozof_2.MAX = setNumFiloz();
			Filozof_2.widelec = new Semaphore[Filozof_2.MAX];
			for(int i = 0; i < Filozof_2.MAX; i++) {
		    	Filozof_2.widelec[i] = new Semaphore(1);
			}
			for (int i = 0; i < Filozof_2.MAX; i++) {
				new Filozof_2(i).start();
			}
		    break;
		  case "3":
			System.out.println("Nr-3 Start!");
			Filozof_3.MAX = setNumFiloz();
			Filozof_3.widelec = new Semaphore[Filozof_3.MAX];
			for(int i = 0; i < Filozof_3.MAX; i++) {
		    	Filozof_3.widelec[i] = new Semaphore(1);
			}
			for (int i = 0; i < Filozof_3.MAX; i++) {
				new Filozof_3(i).start();
			}
			break;
		  case "4":
			  System.out.println("Exit");
			break;
		  default:
		     System.out.println("Error!");
		}
	}
	
	private static int setNumFiloz() {
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj ilosc filozofow od 2 do 1000:");
		n = scan.nextInt();
		while(!(n > 1 && n < 1001)) {
			System.out.println("Error! Podaj ilosc filozofow od 2 do 1000:");
			n = scan.nextInt();
		}
		scan.close();
		return n;
	}
	
	private static boolean sprawdzOpcje(String opcja) {
		String [] op = {"1", "2", "3", "4"};
		for(String s: op) {
			if(opcja.equals(s)) {
				return false;
			}
		}
		return true;
	}
	
}

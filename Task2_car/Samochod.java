package Task2_car;

public class Samochod extends Thread {
	
	private String nrRej;
	private int pojZbiornika;
	private int paliwo;
	
	private boolean jazda;
	
	public Samochod (String nr, int _pojZbiornika) {
		this.nrRej = nr;
		this.pojZbiornika = _pojZbiornika;
		this.paliwo = _pojZbiornika;
	}
	
	public void tankowanie (int _paliwo) {
		this.paliwo += _paliwo;
	}
	
	public void start() {
		jazda = true;
		run();
	} 
	//start samochodu, uruchamiamy w¹tek zu¿ycia paliwa
	
	public void stop_s() {
		jazda = false;
		System.out.println("Brak paliwa! Samochod nr-" + nrRej + " zatrzymal sie!");
        tankowanie(pojZbiornika);
        jazda = true;
        System.out.println("Samochod nr-" + nrRej + " odjechal po zatankowaniu.");
	}
	//zatrzymanie samochodu, zatrzymujemy w¹tek zu¿ycia paliwa
	
	public void run() {
		try {
            if (jazda){
                Thread.sleep(1000);
                System.out.println("Samochod nr-" + nrRej + " jedzie! Ilosc paliwa: " + paliwo);
                paliwo -= 50;
                if (paliwo <= 0) {
                	stop_s();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}//kod, który wykonuje siê w odrêbnym w¹tku, co 1 s programu zu¿ywany jest 1 litr paliwa - 50
}
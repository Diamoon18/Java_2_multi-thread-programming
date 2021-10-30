package Task2_car;

public class TestSamochod {
	
	public static void main(String[] args) {
		Samochod [] auta = {new Samochod("11Y", 100), new Samochod("12a34", 200),
							new Samochod("1880W", 150), new Samochod("98-12", 250),
							new Samochod("23u32", 50), new Samochod("087-2e", 300)};
		while(true) {
			for(Samochod s : auta) {
				s.start();
			}
		}
		
	}
}

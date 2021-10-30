package Task1_timepiece;

public class Czasomierz extends Thread{
	private static int sekundy, minuty, godziny;
	public static String time = "";
	
	public String getTime() {
		return time;
	}
	
	public Czasomierz(int godziny, int minuty, int sekundy) {
		Czasomierz.godziny = godziny;
		Czasomierz.minuty = minuty;
		Czasomierz.sekundy = sekundy;
		
	}
	
	@Override
    public void run() {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                
                time = time();
                System.out.println(time);
                
                if (sekundy >= 60)
                {
                    sekundy = 0;
                    minuty++;
                }
                if (minuty >= 60)
                {
                    minuty = 0;
                    godziny++;
                }
                if (godziny >= 24) {
                	godziny = 0;
                }
                sekundy++;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
	
	private String time() {
		if(godziny == 0) {
        	if (minuty >= 0 && minuty <= 9 && sekundy > 9)
            {
                return "00:0" + minuty + ":" + sekundy;
            } 
        	else if (sekundy >= 0 && sekundy <= 9 && minuty >= 9) 
        	{
        		return "00:" + minuty + ":0" + sekundy;
            } 
        	else if ((sekundy >= 0 && sekundy <= 9) && (minuty >= 0 && minuty <= 9)) 
        	{
        		return "00:0" + minuty + ":0" + sekundy;
            } else {
            	return "00:" + minuty + ":" + sekundy;
            }
        } else if (godziny > 0 && godziny <= 9) {
        	if (minuty >= 0 && minuty <= 9 && sekundy > 9)
            {
        		return "0" + godziny + ":0" + minuty + ":" + sekundy;
            } 
        	else if (sekundy >= 0 && sekundy <= 9 && minuty > 9) 
        	{
        		return "0" + godziny + ":" + minuty + ":0" + sekundy;
            } 
        	else if ((sekundy >= 0 && sekundy <= 9) && (minuty >= 0 && minuty <= 9)) 
        	{
        		return "0" + godziny + ":0" + minuty + ":0" + sekundy;
            } else {
            	return "0" + godziny + ":" + minuty + ":" + sekundy;
            }
        } else if (godziny > 9) {
        	if (minuty >= 0 && minuty <= 9 && sekundy > 9)
            {
        		return godziny + ":0" + minuty + ":" + sekundy;
            } 
        	else if (sekundy >= 0 && sekundy <= 9 && minuty > 9) 
        	{
        		return godziny + ":" + minuty + ":0" + sekundy;
            } 
        	else if ((sekundy >= 0 && sekundy <= 9) && (minuty >= 0 && minuty <= 9)) 
        	{
        		return godziny + ":0" + minuty + ":0" + sekundy;
            } else {
            	return godziny + ":" + minuty + ":" + sekundy;
            }
        }
		return "Error";
	}
}

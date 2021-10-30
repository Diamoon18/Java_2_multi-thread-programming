package Task3_MonteCarlo;

public class Punkt {
    private int x;
    private int y;
    
    Punkt(int x, int y){
    	this.x = x;
    	this.y = y;
    }
    
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override 
    public String toString() {
		return "Punkt: f("+ x + ") = " + y;
    }
}
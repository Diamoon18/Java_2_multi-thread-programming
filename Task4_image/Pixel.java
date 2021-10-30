package Task4_image;

import java.awt.Color;

public class Pixel {
	private int j, i;
	private Color color;

	public Pixel(int j, int i, Color color) {
		this.i = i;
		this.j = j;
		this.color = color;
	}

	public int getJ() {
		return j;
	}

	public int getI() {
		return i;
	}

	public Color getColor() {
		return color;
	}
}

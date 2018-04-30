//TODO: if you use this class because you dont have your
//previous SimpleColor, you must document the code with comments
//and fix the setters so they don't invalidate the [0-255] rule
public class SimpleColor {
	private int r;
	private int g;
	private int b;

	public SimpleColor() {}

	public SimpleColor(int r, int g, int b) {
		setR(r);
		setG(g);
		setB(b);
	}
	public SimpleColor(SimpleColor b) {
		this(b.r,b.g,b.b);
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		if (r < 0 ^ r > 255) {
			throw new ColorException("Problem with red");
		}
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		if (g < 0 ^ g > 255) {
			throw new ColorException("Problem with green");
		}
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		if (b < 0 ^ b > 255) {
			throw new ColorException("Problem with blue");
		}
		this.b = b;
	}

	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof SimpleColor &&
                this.r == ((SimpleColor) obj).r && this.g == ((SimpleColor) obj).g && this.b == ((SimpleColor) obj).b;
    }

    @Override
    public String toString() {
        return "Color:" + r + "/" + g + "/" + b;
    }
}

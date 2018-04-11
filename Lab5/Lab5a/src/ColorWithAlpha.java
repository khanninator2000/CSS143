public class ColorWithAlpha extends SimpleColor {
    private int alpha;

    public ColorWithAlpha(int alpha) {
        super(0,0,0);
        setAlpha(alpha);
    }

    public ColorWithAlpha(int r, int g, int b, int alpha) {
        super(r, g, b);
        setAlpha(alpha);
    }

    public ColorWithAlpha(ColorWithAlpha color) {
        super(color.getR(), color.getG(), color.getB());
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        if (alpha < 0 || alpha > 255) {
            throw new ColorException("Problem with alpha");
        }
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return super.toString() + "/" + alpha;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof ColorWithAlpha && super.equals(obj) &&
                this.alpha == ((ColorWithAlpha) obj).alpha;
    }
}

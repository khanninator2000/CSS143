public class Fraction {
    public final int numerator;
    public final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Fraction fraction) {
        this(fraction.numerator, fraction.denominator);
    }

    public Fraction add(Fraction other) {
        return new Fraction(this.numerator * other.denominator + other.numerator * this.denominator,
                this.denominator * other.denominator);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Fraction &&
                this.numerator == ((Fraction) obj).numerator && this.denominator == ((Fraction) obj).denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

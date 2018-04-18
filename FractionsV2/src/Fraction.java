// Krish Kalai
// CSS 143 B
// FractionsV2

/**
 * Class that stores a fraction (where the numerator and denominators are integers).
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(0,0);
    }

    public Fraction(int numerator, int denominator) {
        setFraction(numerator, denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        setFraction(numerator, this.denominator);
    }

    public void setDenominator(int denominator) {
        setFraction(this.numerator, denominator);
    }

    /**
     * This method sets a numerator and/or denominator to a Fraction of it's simplest
     * form.
     */
    private void setFraction(int numerator, int denominator) {
        int gcd = binaryGCD(numerator, denominator);
        if (gcd == 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        else {
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }
    }

    /**
     * Recursive method that uses the binary GCD/Stein's method for GCD.
     * This has a 60% efficiency over Euler's method (despite both being quadratic time).
     *
     * @param u The numerator of the fraction.
     * @param v The denominator of the fraction.
     * @return The GCD of the u and v.
     */
    private int binaryGCD(int u, int v) {
        // base cases
        if (u == v) {
            return u;
        }
        if (u == 0) {
            return v;
        }
        if (v == 0) {
            return u;
        }

        if ((u & 1) == 0) {
            if ((v & 1) == 0) {
                // u and v are both even
                return binaryGCD(u >> 1, v >> 1) << 1;
            }
            else {
                //u is even and v is odd
                return binaryGCD(u >> 1, v);
            }
        }
        else {
            if ((v & 1) == 0) {
                // u is odd and v is even
                return binaryGCD(u, v >> 1);
            }

            // reduce larger argument
            if (u > v) {
                return binaryGCD((u - v) >> 1, v);
            }
            else {
                return binaryGCD((v - u) >> 1, u);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction)obj;
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

// Krish Kalai
// CSS 143 B
// FractionsV2

/**
 * Immutable Fraction class.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    private Fraction() {
        //no-op
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Method that returns a simplified fraction.
     *
     * @return This if the GCD is 0 or a simplified fraction if the GCD is not 0.
     *
     */
    public Fraction simplify() {
        //int gcd = GCDEuclidean(this.numerator, this.denominator);
        int gcd = GCDEuclidean(this.numerator, this.denominator);
        if (gcd == 0) {
            return this;
        }
        else {
            return new Fraction(this.numerator / gcd, this.denominator / gcd);
        }
    }

    /**
     * Recursive method that uses the Euclidean method to find the GCD.
     *
     * @param a The numerator of the fraction.
     * @param b The denominator of the fraction.
     * @return The GCD of the fraction.
     */
    private int GCDEuclidean(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return GCDEuclidean(b, a%b);
    }

    private int binaryGCD(int num, int den) {
        if (num == den) {
            return num;
        }
        if (num == 0) {
            return den;
        }
        if (den == 0) {
            return num;
        }

        if ((num & 1) == 0) {
            if ((den & 1) == 0) {
                // u & v are both even
                return binaryGCD(num >> 1, den >> 1);
            }
            else {
                // u is even, v is odd
                return binaryGCD(num >> 1, den);
            }
        }
        else {
            if ((den & 1) == 0) {
                // u is odd, v is even
                return binaryGCD(num, den >> 1);
            }
            else {
                // u & v are both odd
                if (num >= den) {
                    return binaryGCD((num - den)/2, den);
                }
                else {
                    return binaryGCD((den - num)/2, num);
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction)obj;
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    @Override
    public String toString() {
        Fraction simplified = simplify();
        return simplified.numerator + "/" + simplified.denominator;
    }
}

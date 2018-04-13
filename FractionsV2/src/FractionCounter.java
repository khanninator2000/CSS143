// Krish Kalai
// CSS 143 B
// FractionsV2

/**
 * A class that keeps track of repeated simplified Fractions
 */
public class FractionCounter {
    private Fraction fraction;
    private int count;

    public FractionCounter(Fraction fraction) {
        this.fraction = fraction;
        this.count = 1;
    }

    /**
     * Compares this fraction to the other fraction. If they are equal, increment the counter and return true.
     *
     * @param other The other fraction to compare to.
     * @return True if the Fractions are equal.
     */
    public boolean compareAndIncrement(Fraction other) {
        if (fraction.equals(other)) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return fraction + " has a count of " + count;
    }
}

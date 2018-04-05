// Krish Kalai
// CSS 143 B
// FractionsV1

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class KalaiKrish_FractionsV1 {
    /**
     * Main driver for the program.
     *
     * @param $ Unused command line argument variable
     * @throws FileNotFoundException If the file is not found.
     */
    public static void main(String[] $) throws FileNotFoundException {
        ObjectList<Pair<Fraction, Integer> > fraction_counter = new ObjectList<>();
        Scanner reader = new Scanner(new FileInputStream("fractions.txt"));

        while (reader.hasNextLine()) {
            String[] component = reader.nextLine().split("[/]");
            Fraction f = new Fraction(Integer.parseInt(component[0]), Integer.parseInt(component[1]));
            int index = indexOf(fraction_counter, f);
            if (index == -1) {
                fraction_counter.add(new Pair<>(f, 1));
            }
            else {
                fraction_counter.get(index).setSecond(fraction_counter.get(index).getSecond() + 1);
            }
        }

        for (int i = 0; i < fraction_counter.size(); i++) {
            System.out.println(fraction_counter.get(i).getFirst() + " " + fraction_counter.get(i).getSecond());
        }
    }

    /**
     * Finds the object in the ObjectList, and returns the index.
     *
     * @param list The list to look through.
     * @param item The item to look for.
     * @return An integer of the index of the item in list.
     */
    public static int indexOf(ObjectList<Pair<Fraction, Integer> > list, Fraction item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key_equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Nested class to contain a hidden Fraction object. Objects of this class are immutable.
     */
    private static class Fraction {
        private int numerator;
        private int denominator;

        /**
         * Basic constructor. Parameters are non-restrictive integers.
         *
         * @param numerator The numerator of the fraction.
         * @param denominator The denominator of the fraction.
         */
        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction simplify() {
            int gcd = GCDEuclidean(this.numerator, this.denominator);
            if (gcd == 0) {
                return new Fraction(this.numerator, this.denominator);
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

        /**
         * Overridden toString method for writing fraction objects.
         *
         * @return String in the format of [numerator]/[denominator]
         */
        @Override
        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        /**
         * Tests if a fraction is equal to another fraction. Fractions are considered equal if the numerators and
         * denominators of simplified fractions are equal. This method is along with Object.hashCode() to put the
         * fraction in the map.
         *
         * @param obj Object to compare to.
         * @return False is obj is not a Fraction object or is not equal to this. True otherwise.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Fraction) {
                Fraction f1 = this.simplify();
                Fraction f2 = ((Fraction)obj).simplify();
                return f1.numerator == f2.numerator && f1.denominator == f2.denominator;
            }
            return false;
        }

        /**
         * Hashes a simplified fraction (simplify function is called in this method).
         * This method is uses along with Object.equals() to put the fraction in the map.
         *
         * @return A hash of the Fraction by taking the sum of the
         * numerator and the product of the numerator and denominator.
         */
        @Override
        public int hashCode() {
            Fraction f = simplify();
            return (f.numerator * f.denominator) + f.numerator;
        }
    }
}

/*
 * 1. If a (Hash)Map is an array, then no. This problem requires you to parse all the values, having a lower bound
 * computational complexity as O(n). You need a map (or 2 arrays) to count all the unique fractions, and something to
 * parse the file.
 *
 * 2. One array is the minimum required. It would be a array of a Pair of Fraction and Integer.
 *
 * 3. Yes. Node in Linked Lists.
 *
 * 4. Another GCD solution is binary GCD. If the numerator and denominator are both even, then divide both by 2.
 * If either is odd, then divide the larger by the difference of the 2. This is slightly more efficient, despite
 * it running in quadratic time.
 */
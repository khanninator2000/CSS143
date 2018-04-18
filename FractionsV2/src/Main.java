// Krish Kalai
// CSS 143 B
// FractionsV2

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] $) throws FileNotFoundException {
       Fraction another_fraction = new Fraction(1, 2);
        Date date = new Date();
        System.out.println(another_fraction.equals(null));
        System.out.println(another_fraction.equals(date));
        System.out.println(another_fraction.equals(another_fraction));

        ObjectList<FractionCounter> counter = new ObjectList<>();
        Scanner ifstream = new Scanner(new FileInputStream("fractions.txt"));

        found_a_fraction:
        while (ifstream.hasNextLine()) {
            String[] fraction_component = ifstream.nextLine().split("[/]");
            Fraction current_fraction = new Fraction(Integer.parseInt(fraction_component[0]),
                                                     Integer.parseInt(fraction_component[1]));

            for (FractionCounter f:counter) {
                if (f.compareAndIncrement(current_fraction)) {
                    continue found_a_fraction;
                }
            }

            counter.add(new FractionCounter(current_fraction));
        }

        for (FractionCounter f:counter) {
            System.out.println(f);
        }

        ifstream.close();
    }
}

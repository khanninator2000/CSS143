// Krish Kalai
// CSS 143 B
// FractionsV2

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] $) throws FileNotFoundException {
        ObjectList<FractionCounter> counter = new ObjectList<>();
        Scanner ifstream;

        ifstream = new Scanner(new FileInputStream("fractions.txt"));

        found_a_fraction:
        while (ifstream.hasNextLine()) {
            String[] fraction_component = ifstream.nextLine().split("[/]");
            Fraction current_fraction = new Fraction(Integer.parseInt(fraction_component[0]), Integer.parseInt(fraction_component[1]));

            for (int i = 0; i < counter.size(); i++) {
                if (counter.get(i).compareAndIncrement(current_fraction)) {
                    continue found_a_fraction; //Found this fraction, can skip rest of ObjectArray
                }
            }
            counter.add(new FractionCounter(current_fraction));
        }

        for (int i = 0; i < counter.size(); i++) {
            System.out.println(counter.get(i));
        }

        ifstream.close();
    }
}

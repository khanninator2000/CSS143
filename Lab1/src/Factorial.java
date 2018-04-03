import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] $) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("data1.txt"), true);
        System.out.print("Enter your number here: ");
        pw.print("Enter your number here: ");
        int number = new Scanner(System.in).nextInt();
        pw.println(number);
        System.out.println(factorial(number));
        pw.println(factorial(number));
    }

    /**
     * Recursive factorial method which has a guaranteed value for natural numbers (0 ... inf).
     * @param n An integer greater than or equal to 0.
     * @return The factorial for
     */
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Divisors {
    public static void main(String[] $) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileOutputStream("data2.txt"));
        System.out.print("Enter your number here: ");
        pw.print("Enter your number here: ");
        int number = sc.nextInt();
        pw.println(number);
        System.out.print("Divisors are ");
        pw.print("Divisors are ");
        if (number == 0) {
            System.out.println("0");
            pw.print("0");
        }
        else {
            for (int i = number; i > 0; i--) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                    pw.print(i + " ");
                }
            }
            System.out.println();
            pw.println();
        }
        pw.close();
    }

}

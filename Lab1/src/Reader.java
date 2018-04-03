import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    public static void main(String[] $) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which file to view? ");
        sc = new Scanner(new FileInputStream(sc.nextLine()));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

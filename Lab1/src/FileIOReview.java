
public class FileIOReview {
    public static void main(String[] $) throws java.io.IOException {
        java.util.Scanner sc = new java.util.Scanner(new java.io.FileInputStream("data.txt"));
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

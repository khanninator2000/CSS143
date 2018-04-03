import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayReview {
    public static void main(String[] $) throws java.io.IOException {
        int[] data = {3, 1, -8, 4, -5, 2};
        System.out.println(positive_sum(data));
        System.out.println(indexOf(data, 3));
        print_to_file(data);
    }

    /**
     * Computes the sum of the elements of an int array.
     *
     * @param data Array of integers.
     * @return The sum of the data of an array.
     */
    public static int sum(int[] data) {
        int sum = 0;
        for (int i = -1; (i=-~i) < data.length && (sum += data[i]) == sum;);
        return sum;
    }

    /**
     * Computes the average (arithmetic mean) of the contents of data.
     *
     * @param data Array of integers.
     * @return The sum of the data of an array.
     */
    public static float average(int[] data) {
        return sum(data) / data.length;
    }

    /**
     * Checks if target exists in data. If so, return that index, else return -1.
     *
     * @param data Array of integers to look through.
     * @param target value to look for.
     * @return The index of the first occurrence of target in data, or -1 if not found.
     */
    public static int indexOf(int[] data, int target) {
        int i;
        for (i = 0; i < data.length && data[i] != target; i++);
        return i == data.length ? -1 : i;
    }

    /**
     * Returns the sum of only positive elements in data.
     *
     * @param data The array of integers.
     * @return The sum of all positive integers.
     */
    public static int positive_sum(int[] data) {
        int sum = 0;
        for (int i = -1; (i=-~i) < data.length && ((data[i] > 0 && (sum += data[i]) == sum) || true););
        return sum;
    }

    /**
     * (Re)populates an array with values provided by the user using standard input.
     *
     * @param data Array to repopulate
     */
    public static void populate_array(int[] data) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < data.length && (data[i] = sc.nextInt()) == data[i]; i++);
    }

    /**
     * Writes the contents of the array to the file in the following format
     * CSV of array contents
     * sum of all contents
     * average of contents
     *
     * @param data Array of integers to read from.
     * @throws java.io.IOException If the file could not be opened (due to nonexistence)
     */
    public static void print_to_file(int[] data) throws java.io.IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("data.txt"), true);
        for (int i = 0; i < data.length; pw.print(i < data.length - 1 ? data[i] + ", " : data[i]), i++);
        pw.println();

        int sum;
        pw.println((sum = sum(data)));
        pw.println((float)sum/data.length);
    }
}

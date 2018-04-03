import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Calculator that calculates values from left to right.
 */
public class InfixCalc {
    public static void main(String[] $) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"), true);
        for (java.util.Scanner sc = new java.util.Scanner(new FileInputStream("inputData.txt")); sc.hasNextLine(); pw.println(calculate(sc.nextLine().replaceAll("[ ]", ""))));
    }

    /**
     * Section of code that calculates a value.
     * Precondition: no spaces between operators and numbers
     *
     * @param s Infix String.
     * @return float with the computed value of the string.
     */
    public static float calculate(String s) {
        Pair<Float, Integer> token = get_next_int(s, 0);
        float lhs = token.getKey();
        char operator;
        float rhs;

        while (token.getValue() < s.length()) {
            operator = s.charAt(token.getValue());
            token = get_next_int(s, token.getValue() + 1);
            rhs = token.getKey();
            lhs = perform_operation(lhs, rhs, operator);
        }
        return lhs;
    }

    /**
     * Performs the operation on lhs and rhs based on operator.
     *
     * @param lhs Value on the left side of the operator.
     * @param rhs Value on the right side of the operator.
     * @param operator The operation to perform on lhs and rhs.
     * @return A float with the result of lhs and rhs.
     */
    private static float perform_operation(float lhs, float rhs, char operator) {
        switch (operator) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
            default:
                return lhs;
        }
    }

    /**
     * Gets the next number and ending position on the string s starting at start.
     * This method supports decimals and negative numbers.
     *
     * @param s The String to view.
     * @param start The starting index of the String (method has no bounds check).
     * @return A javafx.util.Pair with the next Integer (token) and the ending index.
     */
    private static Pair<Float, Integer> get_next_int(String s, int start) {
        StringBuilder accumulator = new StringBuilder();
        int i = start;
        for (; i < s.length() && (Character.isDigit(s.charAt(i)) || (accumulator.length() == 0 && s.charAt(i) == '-') || s.charAt(i) == '.'); i++) {
            accumulator.append(s.charAt(i));
        }

        return new Pair<>(Float.parseFloat(accumulator.toString()), i);
    }
}

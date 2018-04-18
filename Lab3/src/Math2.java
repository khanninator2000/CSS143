public class Math2 {
    public static final double PI = 3.1415926536;
    public static final double E = 2.7182818285;

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public strictfp static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static int pow(int base, int exponent) {
        int result = base;
        for (int i = 1; i < exponent; result *= base, i++);
        return result;
    }
}

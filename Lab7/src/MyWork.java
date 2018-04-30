public class MyWork {
    public static void main(String[] args) {
        final int exp = 16;
        
        //System.out.println(factorial(10));
        System.out.println(power(2, exp));
        System.out.println(power_fast(2, exp));
    
        for (int i = 0; i < exp; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
    
    public static int factorial(int input) {
        if (input == 1) {
            return 1;
        }
        return input * factorial(input - 1);
    }
    
    public static long power(final int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    
    public static long power_fast(final int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent % 2 == 0) {
            long next = power_fast(base, exponent/2);
            return next * next;
        }
        else {
            long next = power_fast(base, (exponent - 1)/2);
            return base * (next * next);
        }
    }
    
    public static long fibonacci(final int value) {
        if (value == 0 | value == 1) {
            return 1;
        }
        return fibonacci(value - 2) + fibonacci(value - 1);
    }
    
    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) - factorial(n - r));
    }
    
}

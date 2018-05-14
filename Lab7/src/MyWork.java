import java.io.File;

public class MyWork {
    public static void main(String[] args) {
        final int exp = 32;

        System.out.println(factorial(10));
        
        System.out.println(power(2, exp));
        System.out.println(power_fast(2, exp));
    
        System.out.println(combination(6, 1));
        
        for (int i = 0; i < exp; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    
        System.out.println(directory_search("kit.kat", "/Users/krishkalai/Desktop"));
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
    
    public static String directory_search(String target, String dir_name) {
        File current_file = new File(dir_name);
        if (!current_file.exists()) {
            return null;
        }
        
        String[] file_list = current_file.list();
        if (file_list == null) {
            return null;
        }
        for (String file : file_list) {
            File next = new File(current_file + "/" + file);
            
            if (next.isDirectory()) {
                String ans = directory_search(target, next.getAbsolutePath());
                if (ans != null) {
                    return ans;
                }
            }
            else {
                if (file.equals(target)) {
                    return next.getAbsolutePath();
                }
            }
        }
        return null;
    }
}

/*
 * (2) MyWork::power
 * f(x) = 3N + 2
 * g(x) = 3N + 2N, for N > 1
 *
 * (3) MyWork::power_fast
 * f(x) = 3log_2(N)+2
 * g(x) = 3log_2(N)+2log_2(N), for N > 1
 */

/*
 * if not valid path and directory:
 *     perform failure operation
 * for each item in cd:
 *     if item is -d:
 *         append to absolute path
 *         recurse
 *     else:
 *         if local path matches target filename:
 *             perform success operation
 *         endif
 *     endif
 * endloop
 */
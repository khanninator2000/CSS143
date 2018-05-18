// Krish Kalai
// CSS 143 B
// Recursion

import java.util.Arrays;
import java.util.Objects;

public class FileSearchDriver {
    public static void main(String[] $) {
        FindFile f = new FindFile(10);
        try {
            f.directorySearch("KalaiKrish_ClassesAndInterfaces.zip", "/Users/krishkalai/Desktop");
        } catch (ArrayIndexOutOfBoundsException ignored) {
        
        }
        Arrays.stream(f.getFiles()).filter(Objects::nonNull).forEach(System.out::println);
    }
}

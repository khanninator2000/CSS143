import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FindFile {
    private int max_files;
    private int count;
    String[] files;

    public FindFile(int max_files) {
        this.max_files = max_files;
        count = 0;
        files = new String[max_files];
    }

    public void directory_search(String target, String dir_name) {
        File current_file = new File(dir_name);
        if (!current_file.exists()) {
            throw new IllegalArgumentException("Invalid Directory");
        }

        String[] file_list = current_file.list();
        for (String file : file_list) {
            File next = new File(current_file + "/" + file);
            if (next.isDirectory()) {
                directory_search(target, next.getAbsolutePath());
            }
            else {
                if (file.equals(target)) {
                    if (count > max_files) {
                        throw new ArrayIndexOutOfBoundsException("File count exceeds maximum amount of files.");
                    }
                    files[count++] = next.getAbsolutePath();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public String[] getFiles() {
        return files;
    }

    public static void main(String[] $) {
        FindFile f = new FindFile(3);
        try {
            f.directory_search("robots2.txt", "/Users/krishkalai/Desktop/");
            System.out.println(Arrays.toString(f.getFiles()));
        }catch (ArrayIndexOutOfBoundsException x) {
            System.err.println("Oh... this happened");
        }
    }
}

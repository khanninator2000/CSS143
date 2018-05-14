// Krish Kalai
// CSS 143 B
// Recursion

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class to search for all (or up to {@code count}) instances (local paths) of a file.
 */
public class FindFile {
    /**
     * Number of files found.
     */
    private int count;
    
    /**
     * Array of absolute paths of a file.
     */
    private String[] files;
    
    /**
     * Constructor for this class
     *
     * @param max_files Maximum number of files to be stored.
     */
    public FindFile(int max_files) {
        this.count = 0;
        this.files = new String[max_files];
    }
    
    /**
     * Recursive directory search method.
     *
     * @param target The target file to give (should be a filename)
     * @param dir_name The absolute path of the start (root)
     */
    public void directorySearch(String target, String dir_name) {
        File current_file = new File(dir_name);
        
        for (String file : Objects.requireNonNull(current_file.list())) {
            File next = new File(current_file + "/" + file);
            if (next.isDirectory()) {
                directorySearch(target, next.getAbsolutePath());
            }
            else if (file.equals(target)) {
                files[count++] = next.getAbsolutePath();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public String[] getFiles() {
        return files;
    }
}
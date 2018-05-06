// Krish Kalai
// CSS 143 B
// Recursion

/**
 * Exception for LinearSearch and BinarySearch if the target item cannot be found.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Item not found.");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}

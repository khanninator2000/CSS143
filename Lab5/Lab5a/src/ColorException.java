public class ColorException extends RuntimeException {
    public ColorException() {
        super("An error occurred in color");
    }

    public ColorException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        throw new ColorException("A test in main");
    }
}

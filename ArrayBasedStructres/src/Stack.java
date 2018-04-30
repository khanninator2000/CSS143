// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

/**
 * Implementation of a dynamic-sizing FILO Stack Structure.
 *
 * Push, pop, isEmpty, and size operate in amortized constant time.
 * Equals and toString operate in amortized linear time.
 *
 * This class is non-synchronized. This class is silent-fails only (no Exceptions will be thrown).
 */
public class Stack<T> {
    private Object[] elements;
    private int size;

    /**
     * Initializes the stack with a base size of 8.
     */
    public Stack() {
        this.elements = new Object[8];
        this.size = 0;
    }
    
    /**
     * Adds an item to the top of the stack.
     * If the item is null, the item will not be added to the Stack and will silently fail.
     * If needed, the array will resize to 150% of the original.
     *
     * @param item Item to add to the stack.
     *             If it is null, then this returns without modifying the array.
     */
    public void push(T item) {
        if (item == null) {
            return;
        }
        if (size == elements.length) {
            elements = java.util.Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
        elements[size++] = item;
    }
    
    /**
     * Pops the top from the Stack.
     * If the stack is empty, then this return null.
     *
     * @return The element being removed (from the top of the stack) or null if the size is 0.
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            return null;
        }
        return (T)elements[size--];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Gets the size of the Stack.
     *
     * @return the size of this stack, as an (unsigned) integer.
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Tests if obj is a Stack, and compares all the elements to test equality.
     *
     * @param obj the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Stack)) {
            return false;
        }
        Stack<?> rhs = (Stack<?>)obj;
        
        if (this.size != rhs.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(rhs.elements[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a comma separated representation of the stack.
     * The bottom is after the "[", and the top is after the "]".
     *
     * @return A string to represent a Stack.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            s.append(elements[i]);
            if (i != size - 1) {
                s.append(", ");
            }
        }
        return s + "]";
    }
}

// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

/**
 * Dynamic resizing array-based structure.
 *
 * Construction, size, and isEmpty methods are all constant time.
 * Enqueue, and dequeue are amortized constant time.
 * toString and equals are in linear time.
 *
 * This class is non-synchronous, and this class guarantees no exceptions will be thrown.
 */
public class Queue<T> {
    private Object[] elements;
    private int size;
    
    public Queue() {
        this.elements = new Object[8];
        this.size = 0;
    }
    
    /**
     * Adds an item to the end of the queue.
     * If the item is null, then nothing will happen.
     *
     * @param item The item to add to the queue.
     */
    public void enqueue(T item) {
        if (item == null) {
            return;
        }
        if (size == elements.length) {
            elements = java.util.Arrays.copyOf(elements, elements.length + (elements.length << 1));
        }
        elements[size++] = item;
    }
    
    /**
     * Deletes and returns an item at the front of the queue.
     * If the queue is empty, then return null.
     *
     * @return The item being deleted (at the front of the queue.
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T item = (T)elements[0];
        System.arraycopy(elements, 1, elements, 0, size - 1);
        size--;
        return item;
    }
    
    /**
     * Gets the size of the queue.
     *
     * @return the size of the queue, represented as an integer.
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Checks if the ArrayList is empty.
     *
     * @return True if the array is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Returns a String as a comma separated values of the Queue.
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
        s.append("]");
        return s.toString();
    }
    
    /**
     * Checks if two Queue are equal.
     * Silent fails (returns false) if obj is null or not of type Queue.
     * A ClassCastException may occur based on the impl. of the equals override of the type argument.
     *
     * @param obj the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof Queue<?>)) {
            return false;
        }
        Queue<?> other = (Queue<?>)obj;
        
        if (this.size != other.size) {
            return false;
        }
        
        for (int i = 0; i < this.size; i++) {
            if (!this.elements[i].equals(other.elements[i])) {
                return false;
            }
        }
        return true;
    }
}

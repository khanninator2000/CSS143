// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

/**
 * Dynamic resizing array-based structure.
 *
 * Construction, get, size, and isEmpty methods are all constant time.
 * Insert, removal, toString and equals are done in amortized linear time.
 *
 * This class is non-synchronous, and this class guarantees no exceptions will be thrown.
 */
public class ArrayList<T> {
    private Object[] elements;
    private int size;

    /**
     * Constructs an ArrayList. The base size is set to 8 elements, but is resizeable.
     */
    public ArrayList() {
        elements = new Object[8];
        size = 0;
    }
    
    /**
     * Inserts an item at a specified location.
     * If needed, this method resize the array by 150%.
     *
     * If {@code index < 0 || index > size}, this method silent-fails
     * and does make any changes.
     *
     * @param item The Object to insert. If this is null, then this is not added.
     * @param index The position to insert item.
     *              If this is less than 0 or greater than size, then item is not added.
     */
    public void insert(T item, int index) {
        if (index < 0 || index > size || item == null) {
            return;
        }
        if (size == elements.length) {
            elements = java.util.Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
        System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = item;
        size++;
    }

    /**
     * Deletes an item at the specified index.
     *
     * The right elements of the array are copied one space over
     * to prevent complexity from blank elements.
     *
     * If 0 > index > size or if ArrayList.isEmpty() is true,
     * then this method silent-fails and returns null.
     *
     * @param index The index of the array to delete.
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index >= size) {
            return null;
        }
        T data = (T)elements[index];
        size--;
        System.arraycopy(elements, index+1, elements, index, size - index);
        return data;
    }
    
    /**
     * Gets the object at the specified index.
     *
     * @param index index of element to get
     * @return The Object at the index of the array.
     *
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return (T)elements[index];
    }

    public int indexOf(T object) {
        int i = 0;
        for (; i < size && !elements[i].equals(object); i++);
        return i < size ? i : -1;
    }

    public int size() {
        return size;
    }
    
    /**
     * Checks if the ArrayList is empty.
     *
     * @return True if the array is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a String as a comma separated values of the ArrayList.
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
     * Checks if two ArrayLists are equal.
     * Silent fails (returns false) if obj is null or not of type ArrayList.
     * A ClassCastException may occur based on the impl. of the equals override of the type argument.
     *
     * @param obj the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayList<?>)) {
            return false;
        }
        ArrayList<T> other = (ArrayList<T>)obj;

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

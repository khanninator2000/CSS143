// Krish Kalai
// CSS 143 B
// FractionsV1

/**
 * ArrayList-like class to store data in a dynamic resizing list.
 *
 * @param <T>
 */
public class ObjectList<T> {
    private Object[] elements;
    private int size;

    /**
     * Constructs an ObjectList of 8 elements.
     */
    public ObjectList () {
        elements = new Object[8];
        size = 0;
    }

    /**
     * Add an Object to the next available spot to the array. If no elements are available, then the array will resize.
     *
     * @param item The item to add to the ObjectList.
     */
    public void add(T item) {
        if (size == elements.length) {
            resize_upward();
        }
        elements[size++] = item;
    }

    /**
     * Inserts an item at a specified location.
     *
     * @param item The Object to insert
     * @param index The position to insert item.
     * @throws IndexOutOfBoundsException If the index parameter is out of range
     */
    public void insert(T item, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (size == elements.length) {
            resize_upward();
        }
        System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
//        for (int i = elements.length-1; i > index; i--) {
//            elements[i] = elements[i-1];
//        }
        elements[index] = item;
        size++;
    }

    /**
     * Deletes an item at the specified index.
     *
     * @param index The index to delete.
     * @throws IndexOutOfBoundsException If the index parameter is out of range
     */
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
//        for (int i = index; i < size; i++) {
//            elements[i+1] = elements[i];
//        }
    }

    /**
     * This method is called if the array is out of space. A new array of current_length * 150% is created.
     */
    private void resize_upward() {
        Object[] temp_elements = new Object[elements.length + (elements.length >> 1)];
        System.arraycopy(elements, 0, temp_elements, 0, elements.length);
//        for (int i = 0; i < elements.length; i++) {
//            temp_elements[i] = elements[i];
//        }
        elements = temp_elements;
    }

    /**
     * Gets the object at the specified index.
     *
     * @param index index of element to get
     * @throws IndexOutOfBoundsException If the index parameter is out of range
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        return (T)(elements[index]);
    }

    public int size() {
        return size;
    }

    /**
     * Returns a String as a comma separated values of the List.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            s.append(elements[i]);
            if (i != size - 1) {
                s.append(",");
            }
        }
        s.append("]");
        return s.toString();
    }
}

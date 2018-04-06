// Krish Kalai
// CSS 143 B
// FractionsV1

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ArrayList-like class to store data in a dynamic resizing list.
 */
public class ArrayList<T> implements Iterable<T>{
    private Object[] elements;
    private int size;

    /**
     * Constructs an ObjectList of 8 elements.
     */
    public ArrayList() {
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
    }

    /**
     * This method is called if the array is out of space. A new array of current_length * 150% is created.
     */
    private void resize_upward() {
        Object[] temp_elements = new Object[elements.length + (elements.length >> 1)];
        System.arraycopy(elements, 0, temp_elements, 0, elements.length);
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

    /**
     * Creates a new Iterator for when starting the for-each loop.
     *
     * @return new ArrayListIterator Object.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Impl. of what the for each loop should read.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < size; i++) {
            action.accept((T)elements[i]);
        }
    }

    /**
     * Iterator class to iterate through the ArrayList.
     * The iterator will start from index 0, up to index {@code size}.
     */
    private class ArrayListIterator implements Iterator {
        private int current_index = 0;

        /**
         * Checks if there is another accessible element in the Array.
         */
        @Override
        public boolean hasNext() {
            return current_index < size;
        }

        /**
         * Returns the next object (as type Object) in the array,
         * given that {@code Iterator::hasNext} is true.
         */
        @Override
        public Object next() {
            return elements[current_index++];
        }
    }
}

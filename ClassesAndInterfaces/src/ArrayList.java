// Krish Kalai
// CSS 143 B
// ClassesAndInterfaces

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * ArrayList-like class to store data in a dynamic resizing list.
 */
public class ArrayList<T> implements Iterable<T> {
    /**
     * Array to store the data
     */
    protected Object[] elements;
    
    /**
     * Size (number of accessible elements) of the ArrayList.
     */
    protected int size;

    /**
     * Constructs an ArrayList of 8 elements.
     */
    public ArrayList() {
        elements = new Object[8];
        size = 0;
    }

    /**
     * Add an Object to the next available spot to the array.
     * If no elements are available, then the array will resize.
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
            throw new IndexOutOfBoundsException("" + index);
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
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("" + index);
        }
        T item = (T) elements[index];
        System.arraycopy(elements, index, elements, index + 1, size - index);
        return item;
    }

    /**
     * This method is called if the array is out of space. A new array of current_length * 150% is created.
     */
    protected void resize_upward() {
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
            throw new IndexOutOfBoundsException("" + index);
        }

        return (T)(elements[index]);
    }
    
    /**
     * Gets the size of the ArrayList.
     *
     * @return the size of the ArrayList.
     */
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
     * Creates a new Iterator for when starting a for-each loop
     * or iteration cycle.
     *
     * @return new ArrayListIterator Object.
     */
    @Override
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current_index = 0;
        
            @Override
            public boolean hasNext() {
                return current_index < size;
            }
        
            @Override
            public T next() {
                if (current_index > size) {
                    throw new NoSuchElementException();
                }
                return (T) elements[current_index++];
            }
        };
    }

    /**
     * Impl. of what the for each loop should process.
     *
     * @param action Consumer lambda to do one operation
     */
    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < size; i++) {
            action.accept((T)elements[i]);
        }
    }
}

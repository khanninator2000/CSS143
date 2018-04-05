// Krish Kalai
// CSS 143 B
// FractionsV2

public class ArrayList {
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
    public void add(Object item) {
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
     */
    public void insert(Object item, int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
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
     * The right elements of the array are copied one space over
     * to prevent complexity from blank elements.
     *
     * @param index The index of the array to delete.
     * @throws IndexOutOfBoundsException if 0 < {@code index} >= {@code size}
     */
    public Object remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object data = elements[index];
        size--;
        System.arraycopy(elements, index+1, elements, index, size - index);
        return data;
    }

    /**
     * This method is called if the array is out of space.
     * A new array of length + (150% * length) is created.
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
     * @return The Object at the index of the array.
     * @throws IndexOutOfBoundsException If 0 < {@code index} >= {@code size}.
     *
     */
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}

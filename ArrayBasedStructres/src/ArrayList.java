// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class ArrayList<T> {
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
        if (item == null) {
            return;
        }
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
    public void insert(T item, int index) {
        if (index > size || item == null) {
            return;
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
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        T data = (T)elements[index];
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
     *
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        assert index < size : "Out of bounds";
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

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayList)) {
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

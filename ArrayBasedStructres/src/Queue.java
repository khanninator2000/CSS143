// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class Queue<T> {
    private Object[] elements;
    private int size;

    private int start;
    private int end;

    private boolean loop;

    public Queue() {
        this.elements = new Object[8];
        this.size = 0;

        this.start = 0;
        this.end = 0;

        this.loop = false;
    }

    public void enqueue(T item) {
        if (item == null) {
            return;
        }
        if (size == elements.length) {
            resize_upwards();
            start = 0;
            end = size;
            loop = false;
        }
        elements[end] = item;
        end++;
        if (end == elements.length) {
            end %= elements.length;
            loop = true;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T item = (T)elements[start];
        start++;
        if (start == elements.length) {
            start %= elements.length;
            loop = false;
        }
        size--;
        return item;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (!loop) {
            for (int i = start; i < end; i++) {
                str.append(elements[i]);
                if (i != end - 1) {
                    str.append(", ");
                }
            }
        }
        else {
            for (int i = start; i < elements.length; i++) {
                str.append(elements[i]);
                if (i != elements.length - 1) {
                    str.append(", ");
                }
            }
            for (int i = 0; i < end; i++) {
                str.append(", ");
                str.append(elements[i]);
            }
        }
        return str + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Queue<?>)) {
            return false;
        }

        Queue<?> queue = (Queue<?>)obj;
        return this.toString().equals(queue.toString());
    }

    private void resize_upwards() {
        Object[] temp_elements = new Object[this.elements.length << 1];
        if (!loop) {
            System.arraycopy(elements, start, temp_elements, 0, end - start);
        }
        else {
            System.arraycopy(elements, start, temp_elements, 0, this.elements.length - start);
            System.arraycopy(elements, 0, temp_elements, start+1, end);
        }
        this.elements = temp_elements;
    }
}

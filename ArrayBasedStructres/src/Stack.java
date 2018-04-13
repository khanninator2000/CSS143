// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

public class Stack<T> {
    private Object[] elements;
    private int size;

    public Stack() {
        this.elements = new Object[8];
        this.size = 0;
    }

    public void push(T item) {
        elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            return null;
        }
        return (T)elements[size--];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Stack)) {
            return false;
        }
        Stack rhs = (Stack)obj;
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(rhs.elements[i])) {
                return false;
            }
        }
        return true;
    }

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

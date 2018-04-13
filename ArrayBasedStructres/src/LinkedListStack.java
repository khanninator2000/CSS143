import java.util.EmptyStackException;

/**
 * Implementation of a linked list based LIFO queue.
 */
public class LinkedListStack {
    /**
     * The top of the stack (for O(1) retrieval).
     */
    private Node head;

    private int size;

    LinkedListStack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds a {@code Node} with {@code data} to the head of the stack.
     * Side effect: {@code size} is incremented
     *
     * @param data The Object to add to the List
     */
    void push(Object data) {
        Node new_node = new Node(data);
        size++;
        if (head == null) {
            head = new_node;
        }
        else {
            new_node.next = head;
            head = new_node;
        }
    }

    /**
     * Removes the top element from the LinkedListStack and returns it.
     * Side effect: {@code size} is decremented
     *
     * @return the top element of the stack.
     */
    Object pop() {
        if (head == null) {
            throw new EmptyStackException();
        }

        size--;
        Object top = head.data;
        head = head.next;
        return top;
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        for (Node iter = head; iter != null; iter = iter.next) {
            str.append(iter.data);
            if (iter.next != null) {
                str.append(", ");
            }
        }

        str.append("]");
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LinkedListStack)) {
            return false;
        }

        if (this.size != ((LinkedListStack)obj).size) {
            return false;
        }

        for (Node ti = this.head, oi = ((LinkedListStack) obj).head; ti != null && oi != null; ti = ti.next, oi = oi.next) {
            if (!ti.equals(oi)) {
                return false;
            }
        }
        return true;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}

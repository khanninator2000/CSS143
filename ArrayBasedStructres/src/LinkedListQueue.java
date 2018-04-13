// Krish Kalai
// CSS 143 B
// ArrayBasedStructures

/**
 * Implementation of a Linked List based FIFO queue.
 */
public class LinkedListQueue {
    private Node head;
    private Node tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an object to the beginning (head) of the list and increases the size by 1.
     *
     * @param object The object to add.
     */
    public void enqueue(Object object) {
        Node new_object = new Node(object);
        this.size++;
        if (head == null) {
            head = new_object;
            tail = new_object;
        }
        else {
            new_object.next = head;
            head.prev = new_object;
            head = new_object;
        }
    }

    /**
     * Removes the last object (tail), decrements the size and returns the Object.
     *
     * @return The tail Object in the queue.
     * @throws IllegalStateException If the queue has no elements.
     */
    public Object dequeue() {
        if (tail == null) {
            throw new IllegalStateException("LinkedListQueue is empty.");
        }
        Object return_value = tail.data;
        this.size--;
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            tail = null;
            head = null;
        }
        return return_value;
    }

    /**
     * Gets the size (number of elements) of the queue.
     *
     * @return An integer representing the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Tests if the queue is empty.
     *
     * @return A boolean, true if the size is 0
     *         (alternately, head/tail is null),
     *         and false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof LinkedListQueue && toString().equals(obj.toString());
    }

    /**
     * Gets a String representation of the LinkedListQueue, as comma separated values.
     *
     * @return A String with comma separated values of the elements of the queue.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        for (Node it = head; it != null; it = it.next) {
            str.append(it.data);
            if (it.next != null) {
                str.append(", ");
            }
        }

        str.append("]");
        return str.toString();
    }

    /**
     * Private nested Node class to build the LinkedListQueue with.
     * This approach is more efficient than using an array,
     * because a linked list has O(1) for insertion and deletion,
     * compared to O(N) for array insertion.
     */
    private class Node {
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        @Override
        public boolean equals(Object obj) {
            return obj != null && obj instanceof Node && this.data == ((Node) obj).data;
        }
    }
}

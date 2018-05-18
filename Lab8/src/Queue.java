public class Queue<T> {
    private Node<T> head;
    
    Queue() {
    
    }
    
    public void enqueue(T item) {
        Node<T> next = new Node<>(item);
        if (head == null) {
            head = next;
            return;
        }
        next.next = head;
        head = next;
    }
    
    @SuppressWarnings("unchecked")
    public T dequeue() {
        Node end = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            T data = (T) head.data;
            head = null;
            return data;
        }
        for (; end.next.next != null; end = end.next) ;
        T data = (T) end.next.data;
        end.next = null;
        return data;
    }
    
    public int size() {
        int count = 0;
        for (Node current = head; current != null; count++, current = current.next) ;
        return count;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        for (Node<T> n = head; n != null; n = n.next) {
            result.append(n);
        }
        
        return result.toString();
    }
    
    private class Node<E extends T> {
        private E data;
        private Node<E> next;
        
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
        
        @Override
        public String toString() {
            return data.toString();
        }
    }
    
    public static void main(String[] args) {
        Queue<Character> queue = new Queue<>();
        queue.enqueue('R');
        queue.enqueue('a');
        queue.enqueue('c');
        queue.enqueue('e');
        queue.enqueue('c');
        queue.enqueue('a');
        queue.enqueue('r');
        
        System.out.println("queue.size() = " + queue.size());
        
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}

public class Queue<T> {
    Node head;
    Node tail;
    
    Queue() {
    
    }
    
    public void enqueue(T item) {
        Node next = new Node(item);
        if (head == null) {
        
        }
    }
    
    class Node<S extends T> {
        S data;
        Node<S> next;
    
        public Node(S data) {
            this.data = data;
            this.next = null;
        }
    }
}

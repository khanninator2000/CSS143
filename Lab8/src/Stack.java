public class Stack<T> {
    Node<T> head;
    int size;
    
    {
        head = null;
        size = 0;
    }
    
    public void push(T data) {
        size++;
        if (head == null) {
            head = new Node<T>(data);
            return;
        }
        Node<T> temp = new Node<>(data);
        temp.next = head;
        head = temp;
    }
    
    public T pop() {
        if (head == null) {
            return null;
        }
        size--;
        T data = head.data;
        head = head.next;
        return data;
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node<T> current = head; current != null; current = current.next) {
            s.append(current.data);
        }
        return s.toString();
    }
    
    private class Node<N extends T> {
        N data;
        Node<N> next;
        
        public Node(N data) {
            this.data = data;
            this.next = null;
        }
        
        @Override
        public String toString() {
            return this.data.toString();
        }
    }
}

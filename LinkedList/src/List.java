
public class List {
    private Node head = null;
    
    /**
     * Inserts an item into the list at the desired position.
     *
     * @param item Object to insert
     * @param index Position to insert to. Will throw LinkedListException if is out of bounds.
     * @ If index < 0 or index > size.
     */
    public void insert(Object item, int index) {
        if (index < 0 || index > size()) {
            throw new LinkedListException("Index out of bounds");
        }

        //Inserting into empty List
        if (head == null) {
            head = new Node(item);
            return;
        }

        //Inserting as head
//        if (index == 0) {
//            Node new_node = new Node(item);
//            new_node.next = head;
//            head = new_node;
//            return;
//        }

        Node n = head;
        for(int i = 0; i < index - 1; i++, n=n.next);

        Node new_node = new Node(item);
        new_node.next = n.next;
        n.next = new_node;
    }

    /**
     * Removes and returns the object from the desired index
     *
     * @param index
     * @return
     * @
     */
    public Object remove(int index) {
        if (index < 0 || index > size()) {
            throw new LinkedListException("Index out of bounds");
        }

        if(index == 0) {
            Node return_value = head;
            head = head.next;
            return return_value.data;
        }

        Node n = head;
        for (int i = 0; i < index - 1; i++, n = n.next);
        Node return_value = n.next;
        n.next = n.next.next;
        return return_value.data;
    }

    public int size() {
        int size = 0;
        for (Node n = head; n != null; n = n.next, size++);
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int indexOf(Object obj) {
        int idx = 0;
        for(Node n = head; n != null && n.data != obj; n = n.next, idx++);
        return idx < size() ? idx : -1;
    }

    public void append(Object obj) {
        if (head == null) {
            head = new Node(obj);
            return;
        }

        Node n = head;
        for (; n.next != null; n = n.next);
        n.next = new Node(obj);
    }

    @Override
    public String toString() {
        String s = "[";
        for (Node n = head; n != null; s += n.data + (n.next == null ? "" : ", "), n = n.next) ;
        s = s.trim() + "]";
        return s;
    }

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] $) {
        List list = new List();
        //list.append(0);
        list.insert(0, 0);
        for (int i = 1; i < 5; i++) {
            //list.append(i);
            list.insert(i, 1);
            System.out.println(list);
        }

        System.out.println();

        for (int i = -1; i < 5; i++) {
            System.out.println(list.indexOf(i));
        }

        System.out.println();

        for (int i = 4; i > 0; i--) {
            list.remove(i);
            System.out.println(list);
        }
        list.remove(0);
        System.out.println(list);
    }
}

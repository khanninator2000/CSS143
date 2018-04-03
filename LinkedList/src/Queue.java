public class Queue extends List {
    public Queue() {
        super();
    }

    public void enqueue(Object obj) throws LinkedListException {
        super.insert(obj, 0);
    }

    public Object dequeue() throws LinkedListException {
        return super.remove(size()-1);
    }

    @Override
    public void insert(Object item, int index) throws LinkedListException {
        this.enqueue(item);
    }

    @Override
    public Object remove(int index) throws LinkedListException {
        return this.dequeue();
    }

    public static void main(String[] $) throws LinkedListException {
        Queue queue = new Queue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue);
    }
}

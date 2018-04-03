public class Stack extends List {

    Stack() {
        super();
    }

    public void push(Object obj) throws LinkedListException {
        super.insert(obj, 0);
    }

    public Object pop() throws LinkedListException {
        return super.remove(0);
    }

    @Override
    public void insert(Object item, int index) throws LinkedListException {
        this.push(item);
    }

    @Override
    public Object remove(int index) throws LinkedListException {
        return this.pop();
    }

    public static void main(String[] $) throws LinkedListException {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        for (int i = 0; i < 5; i++) {
            stack.insert(i+5, 423423);
            System.out.println(stack);
        }

        for (int i = 10; i > 5; i--) {
            System.out.println(stack.pop());
        }
        for (int i = 5; i > 0; i--) {
            System.out.println(stack.remove(246782));
        }
    }
}

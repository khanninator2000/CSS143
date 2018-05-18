// Krish Kalai
// CSS 143 B
// ClassesAndInterfaces

public class ExpenseAccount<T extends Bill> extends ArrayList<T> {
    @Override
    public void add(T item) {
        if (size == elements.length) {
            resize_upward();
        }
        for (int i = 0; i < size; i++) {
            if (item.compareTo((Bill)elements[i]) < 0) {
                super.insert(item, i);
                return;
            }
        }
        elements[size++] = item;
    }
    
    @Override
    public void insert(T item, int index) {
        throw new UnsupportedOperationException("Cannot insert into position of ExpenseAccount.");
    }
}

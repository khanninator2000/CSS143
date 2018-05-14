import java.io.*;

public class ExpenseAccount<T extends Bill> extends ArrayList<T> implements Serializable {
    ExpenseAccount() {
        super();
    }
    
    @Override
    public void add(T item) {
        if (size == elements.length) {
            resize_upward();
        }
        for (int i = 0; i < size; i++) {
            if (item.compareTo((Bill)elements[i]) < 0) {
                size++;
                System.arraycopy(elements, i, elements, i+1, elements.length - 1);
                elements[i] = item;
                return;
            }
        }
        elements[size++] = item;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)super.get(index).clone();
    }
    
    @SuppressWarnings("unchecked")
    public void readObject(String file){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ExpenseAccount<Bill> expenseAccount = (ExpenseAccount)ois.readObject();
            this.elements = expenseAccount.elements;
            this.size = expenseAccount.size;
        } catch (IOException | ClassNotFoundException ignored) {
        
        }
    }
    
    @SuppressWarnings("unchecked")
    public void writeObject(String file){
        try {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(file));
            ois.writeObject(this);
        } catch (IOException ignored) {
        
        }
    }
}

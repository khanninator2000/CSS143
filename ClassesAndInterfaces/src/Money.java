import java.io.Serializable;

/**
 * Class to hold Money in USD.
 */
public class Money implements Comparable, Cloneable, Serializable {
    private int dollars;

    /**
     * An integer between 0 and 99. If this value exceeds 99, the (integer) quotient is added to dollars and the
     * modulo to 100 is saved.
     */
    private int cents;

    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }

    public Money(int dollars) {
        this.dollars = dollars;
        this.cents = 0;
    }

    public Money(int dollars, int cents) {
        setMoney(dollars, cents);
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public void setMoney(int dollars, int cents) {
        this.dollars = dollars + cents/100;
        this.cents = cents % 100;
    }

    public double getMoney() {
        return dollars + (cents/100.);
    }

    public void add(int dollars) {
        this.dollars += dollars;
    }

    public void add(int dollars, int cents) {
        this.dollars += dollars + (this.cents + cents) / 100;
        this.cents = (this.cents + cents) % 100;
    }

    public void add(Money money) {
        add(money.dollars, money.cents);
    }

    @Override
    public boolean equals(Object oth) {
        return oth instanceof Money && this.dollars == ((Money) oth).dollars && this.cents == ((Money) oth).cents;
    }

    @Override
    public String toString() {
        return "$" + String.format("%.2f", getMoney());
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Money) {
            return Double.compare(getMoney(), ((Money)o).getMoney());
        }
        throw new ClassCastException(o.getClass() + "cannot be casted to" + getClass());
    }

    @Override
    protected Money clone() throws CloneNotSupportedException {
        Money money = (Money)super.clone();
        money.setMoney(this.dollars, this.cents);
        return money;
    }
}

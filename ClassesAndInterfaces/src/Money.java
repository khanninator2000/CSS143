import java.io.Serializable;

/**
 * Class to hold money, counted as USD currency.
 */
public class Money implements Comparable, Cloneable, Serializable {
    private int dollars;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Money)) {
            return false;
        }
        Money money = (Money)obj;
        return this.dollars == money.dollars && this.cents == money.cents;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "$" + String.format("%.2f", getMoney());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Money) {
            return Double.compare(getMoney(), ((Money)o).getMoney());
        }
        throw new ClassCastException(o.getClass() + "cannot be casted to" + getClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Money clone() {
        try {
            Money money = (Money) super.clone();
            money.setMoney(this.dollars, this.cents);
            return money;
        } catch (CloneNotSupportedException x) {
            return null;
        }
    }
}



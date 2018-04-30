// Krish Kalai
// CSS 143 B
// PrivacyLeakHomework

/**
 * Class to hold Money in USD.
 */
public class Money {
    private int dollars;
    private int cents;

    public Money() {
        this(0,0);
    }
    
    public Money(int dollars) {
        this(dollars, 0);
    }
    
    public Money(Money money) {
        this(money.dollars, money.cents);
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
        requireInvariant(dollars, cents);
        this.dollars = dollars + cents/100;
        this.cents = cents % 100;
    }

    public double getMoney() {
        return dollars + (cents/100f);
    }

    public void add(int dollars) {
        add(dollars, 0);
    }

    public void add(int dollars, int cents) {
        requireInvariant(dollars, cents);
        this.dollars += dollars + (this.cents + cents) / 100;
        this.cents = (this.cents + cents) % 100;
    }

    public void add(Money money) {
        add(money.dollars, money.cents);
    }
    
    private void requireInvariant(int dollars, int cents) {
        if (dollars < 0 || cents < 0) {
            throw new IllegalArgumentException("A value is negative");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            Money money = (Money)obj;
            return this.dollars == money.dollars && this.cents == money.cents;
        }
        return false;
    }

    @Override
    public String toString() {
        return "$" + String.format("%.2f", getMoney());
    }
}

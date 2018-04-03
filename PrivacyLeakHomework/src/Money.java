
public class Money {
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

    public Money(Money money) {
        this.dollars = money.dollars;
        this.cents = money.cents;
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
}

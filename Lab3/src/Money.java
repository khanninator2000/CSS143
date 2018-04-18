import static java.lang.Math.*;

/**
 * Class to hold Money in USD.
 */
public class Money {
    private int dollars;
    private int cents;

    public Money() {
        this(0,0);
    }

    public Money(int dollars, int cents) {
        if (dollars < 0 | cents < 0) {
            this.dollars = 0;
            this.cents = 0;
            throw new IllegalStateException();
        }
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money(double money) {
        this((int)money, (int)round((money - (int)money)*100));
        System.out.println();
    }

    public Money(Money money) {
        this(money.dollars, money.cents);
    }

    public double getMoney() {
        return this.dollars + (this.cents/100f);
    }

    public void add(int dollars) {
        this.add(dollars, 0);
    }

    public void add(double money) {
        this.add((int)money, (int)round((money - (int)money)*100));
    }

    public void add(int dollars, int cents) {
        if (dollars < 0 || cents < 0) {
            throw new IllegalStateException();
        }
        this.dollars += dollars;
        this.cents += cents;
        this.dollars += this.cents / 100;
        this.cents %= 100;
    }

    public void add(Money money) {
        this.add(money.dollars, money.cents);
    }

    public void subtract(int dollars) {
        subtract(dollars, 0);
    }

    public void subtract(double dollars) {
        subtract((int) dollars, (int)round((dollars - (int)dollars)*100));
    }

    public void subtract(int dollars, int cents) {
        int temp_dollars = this.dollars;
        int temp_cents = this.cents;
        this.dollars -= dollars;
        this.cents -= cents;
        while (this.cents < 0) {
            this.cents += 100;
            this.dollars -= 1;
        }

        if (this.dollars < 0) {
            this.dollars = temp_dollars;
            this.cents = temp_cents;
            throw new IllegalStateException();
        }
    }

    public void subtract(Money money) {
        subtract(money.dollars, money.cents);
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

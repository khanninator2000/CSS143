
public class Bill {
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    public Bill(Money amount, Date dueDate, String originator) {
        this.amount = amount;
        this.dueDate = dueDate;
        this.paidDate = null;
        this.originator = originator;
    }

    public Bill(Bill copy) {
        this(copy.amount, copy.dueDate, copy.originator);
        this.dueDate = copy.dueDate;
    }

    public String getOriginator() {
        return originator;
    }

    public boolean isPaid() {
        return paidDate != null;
    }

    public boolean setPaid(Date paidDate) {
        if (paidDate != null && paidDate.isAfter(dueDate)) {
            return false;
        }
        this.paidDate = paidDate;
        return true;
    }

    public boolean setDueDate(Date dueDate) {
        if (isPaid()) {
            return false;
        }
        this.dueDate = dueDate;
        return true;
    }

    boolean setAmount(Money amount) {
        if (isPaid()) {
            return false;
        }
        this.amount = amount;
        return true;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String toString() {
        return amount + " " + dueDate + " " + originator + " " + (isPaid() ? "Paid on " + paidDate : "Not paid");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bill &&
                this.originator.equals(((Bill)obj).originator) && this.dueDate.equals(((Bill)obj).dueDate) &&
                this.paidDate.equals(((Bill)obj).paidDate) && this.amount.equals(((Bill)obj).amount);

    }
}

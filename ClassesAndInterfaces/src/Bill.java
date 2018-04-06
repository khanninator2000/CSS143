import java.io.Serializable;

public class Bill implements Serializable, Cloneable, Comparable {
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

    /**
     * Method that sets the paid date only if the bill hasn't been paid or the attempted date is after the dueDate.
     *
     * @param paidDate The date the bill is being (or was) paid.
     * @return True if the paid_date value is changed. False otherwise.
     *         This method returns true if the bill has not been paid and if the paidDate is before or on the dueDate.
     */
    public boolean setPaid(Date paidDate) {
        if (this.paidDate != null || paidDate != null || paidDate.isAfter(dueDate)) {
            return false;
        }
        this.paidDate = paidDate;
        return true;
    }

    /**
     * Sets the dueDate of the bill only if the bill has not been paid.
     *
     * @param dueDate The new dueDate
     * @return True if the dueDate is changed. False otherwise.
     */
    public boolean setDueDate(Date dueDate) {
        if (isPaid() || dueDate == null) {
            return false;
        }
        this.dueDate = dueDate;
        return true;
    }

    /**
     * (Re)Sets the bill's amount to the desired amount.
     *
     * @param amount The new value.
     * @return True if the change is successful.
     */
    boolean setAmount(Money amount) {
        if (isPaid() || amount == null) {
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

    /**
     * Checks if two Bills are equal. Two bills are defined equal if the originator, dueDate, paidDate, and amount are
     * equal.
     *
     * @param obj The Object (Bill) to compare to.
     * @return True if the two objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bill &&
                this.originator.equals(((Bill)obj).originator) && this.dueDate.equals(((Bill)obj).dueDate) &&
                this.paidDate.equals(((Bill)obj).paidDate) && this.amount.equals(((Bill)obj).amount);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    protected final Bill clone() {
        try {
            return (Bill)super.clone();
        } catch (CloneNotSupportedException x) {
            return null;
        }
    }
}

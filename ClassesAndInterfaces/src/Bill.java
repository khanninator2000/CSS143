// Krish Kalai
// CSS 143 B
// PrivacyLeakHomework

public class Bill implements Comparable<Bill>, Cloneable, java.io.Serializable {
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    
    /**
     * Creates a Bill with the desired amount, due on the dueDate, and due to the originator.
     *
     * @param amount Money object of the amount to be paid.
     * @param dueDate Date object of when the money is due.
     * @param originator String representation of who to pay to.
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this(amount, dueDate, originator, null);
    }

    /**
     * Constructor to do the initial setting.
     */
    private Bill(Money amount, Date dueDate, String originator, Date paidDate) {
        setAmount(amount);
        setPaid(paidDate);
        setDueDate(dueDate);
        setOriginator(originator);
    }
    
    public String getOriginator() {
        return originator;
    }
    
    public Money getAmount() {
        return amount.clone();
    }
    
    public Date getDueDate() {
        return dueDate.clone();
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
        if (this.paidDate == null && paidDate != null && !paidDate.isAfter(dueDate)) {
            this.paidDate = paidDate.clone();
            return true;
        }
        return false;
    }

    /**
     * Sets the dueDate of the bill only if the bill has not been paid.
     *
     * @param dueDate The new dueDate
     * @return True if the dueDate is changed. False otherwise.
     */
    public boolean setDueDate(Date dueDate) {
        if (!isPaid() && dueDate != null) {
            this.dueDate = dueDate.clone();
            return true;
        }
        return false;
    }

    /**
     * (Re)Sets the bill's amount to the desired amount.
     *
     * @param amount The new value.
     * @return True if the change is successful.
     */
    boolean setAmount(Money amount) {
        if (!isPaid() && amount != null) {
            this.amount = amount.clone();
            return true;
        }
        return false;
    }

    public void setOriginator(String originator) {
        if (originator != null) {
            this.originator = originator;
        }
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
        if (obj instanceof Bill) {
            Bill bill = (Bill)obj;
            return this.dueDate.equals(bill.dueDate) &&
                    (this.paidDate == null && bill.paidDate == null) || (this.paidDate != null && this.paidDate.equals(bill.paidDate)) &&
                    this.amount.equals(bill.amount) &&
                    this.originator.equals(bill.originator);
        }
        return false;
    }
    
    /**
     * Returns > 1 if this dueDate is after other's dueDate
     *
     * @param other Notnull Bill argument to compare to.
     * @return integer > 0 if this dueDate is after other's dueDate
     *         integer < 0 if this dueDate is before other's dueDate
     *         integer = 0 if this dueDate is due on the same day as other's dueDate.
     */
    @Override
    public int compareTo(Bill other) {
        return this.dueDate.compareTo(other.dueDate);
    }
    
    @Override
    public Bill clone() {
        try {
            Bill bill = (Bill) super.clone();
            bill.amount = this.amount.clone();
            bill.dueDate = this.dueDate.clone();
            if (this.paidDate != null) {
                bill.paidDate = paidDate.clone();
            }
            return bill;
        } catch (CloneNotSupportedException x) {
            throw new InternalError("Clone operation failed", x);
        }
    }
}

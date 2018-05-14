// Krish Kalai
// CSS 143 B
// ClassesAndInterfaces

import java.text.DecimalFormat;

/**
 * A date class with the Dates in between 1/1/2014 and 31/12/2024. This class
 * assumes that all months have 31 days and there are no leap years.
 */
public class Date implements Comparable<Date>, Cloneable, java.io.Serializable {
    private static final int MIN_DAY = 1 , MIN_MONTH = 1 , MIN_YEAR = 2014;
    private static final int MAX_DAY = 31, MAX_MONTH = 12, MAX_YEAR = 2024;
    
    private int year;
    private int month;
    private int day;

    public Date() {
        this.day = MIN_DAY;
        this.month = MIN_MONTH;
        this.year = MIN_YEAR;
    }
    
    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }
    
    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setYear(int year) {
        requireInvariant(1, 1, year);
        this.year = year;
    }

    public void setMonth(int month) {
        requireInvariant(1, month, 2014);
        this.month = month;
    }

    public void setDay(int day) {
        requireInvariant(day, 1, 2014);
        this.day = day;
    }

    /**
     * Checks if a Date is after this, up to the precision of the day.
     *
     * @param other the Other object to compare to
     * @return Returns true if other is after this.
     */
    public boolean isAfter(Date other) {
        return this.year > other.year ||
               this.year == other.year && (this.month > other.month ||
               this.month == other.month && (this.day > other.day));
    }
    
    /**
     * Private method that checks if all values meet the invariant condition.
     * If any parameter fails to meet, an IllegalArgumentException will be thrown.
     *
     * @param day day to compare to.
     * @param month month to compare to.
     * @param year year to compare to.
     */
    private void requireInvariant(int day, int month, int year) {
        if (day < MIN_DAY || day > MAX_DAY ||
                month < MIN_MONTH || month > MAX_MONTH || year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Value is less than zero");
        }
    }
    
    /**
     * Returns true if 2 objects are equal.
     *
     * @param obj Object (Date) to compare to.
     * @return true if the two Dates are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date)obj;
            return this.year == date.year &&
                   this.month == date.month &&
                   this.day == date.day;
        }
        return false;
    }

    @Override
    public String toString() {
        return new DecimalFormat("00").format(month) + "/" +
               new DecimalFormat("00").format(day) + "/" +
               new DecimalFormat("0000").format(year);
    }
    
    /**
     * Returns the difference in days.
     *
     * @param other The Date to compare to.
     * @return An integer representing the difference of the days.
     *         The value will be < 0 if this is before other.
     *         The value will be = 0 if this is equal to other.
     *         The value will be > = if this is after other.
     */
    @Override
    public int compareTo(Date other) {
        int other_days = other.year * 372;
        other_days += other.month * 31;
        other_days += other.day;
    
        int this_days = this.year * 372;
        this_days += this.month * 31;
        this_days += this.day;
        
        return this_days - other_days;
    }
    
    @Override
    public Date clone() {
        try {
            return (Date)(super.clone());
        } catch (CloneNotSupportedException x) {
            throw new InternalError("Clone operation failed.");
        }
    }
}

package FedTaxCalc.Exceptions;

/**
 * An exception that denotes that the year has been changed due to an error. 
 * The new year is included with the exception message. 
 * @author Ramin
 */
public class TaxCalculatorYearException extends TaxCalculatorException {
    private int year;
    
    /**
     * Constructs a new TaxCalculatorYearException. 
     * @param message message about the exception
     * @param year the year that is now set in the tax calculator. 
     */
    public TaxCalculatorYearException(String message, int year) {
        super(message);
        this.year = year;
    }
    
    /**
     * Gives the new tax year that has been set in the Tax Calculator. 
     * @return an int representing the new tax year. 
     */
    public int getNewYear() {
        return year; 
    }
}

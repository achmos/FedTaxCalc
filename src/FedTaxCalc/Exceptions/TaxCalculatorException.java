package FedTaxCalc.Exceptions;

/**
 * Custom exception for the Federal Tax Calculator. All checked exceptions for
 * the tax calculator utilize this class or inherit from it. 
 * @author Ramin
 */
public class TaxCalculatorException extends Exception {
    /**
     * Constructor for TaxCalculatorException
     * @param message message about the exception
     */
    public TaxCalculatorException(String message) {
        super(message);
    }
}

package FedTaxCalc.Exceptions;

/**
 * Unchecked Exception class for the Tax Calculator. Denotes an error in loading
 * tax data. Cannot proceed with program operation without the data, so this 
 * exception inherits from RuntimeException.
 * @author Ramin
 */
public class TaxDataLoadFailException extends RuntimeException {
    /**
     * Constructs a new TaxDataLoadFailException object.
     * @param message message about the exception
     */
    public TaxDataLoadFailException(String message) {
        super("Tax data load fail:" + message);
    }
}

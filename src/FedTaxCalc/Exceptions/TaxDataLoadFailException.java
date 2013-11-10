package FedTaxCalc.Exceptions;

/**
 *
 * @author Ramin
 */
public class TaxDataLoadFailException extends RuntimeException {
    public TaxDataLoadFailException(String message) {
        super("Tax data load fail:" + message);
    }
}

package FedTaxCalc;

import FedTaxCalc.Exceptions.TaxCalculatorException;
import FedTaxCalc.Exceptions.TaxDataLoadFailException;
import FedTaxCalc.Loaders.TaxYearsLoader;
import java.util.HashMap;

/**
 * A tax calculator object that return the amount of U.S Federal Income tax that
 * must be paid on a certain amount of taxable income. 
 * @author Ramin
 */
public class FedTaxCalc {
    FilingType FilingStatus;
    TaxYear currentYear;
    HashMap<Integer,TaxYear> TaxableYears;
    
    /**
     * Create a new FedTaxCalc object which can be used to calculate taxes. 
     */
    public FedTaxCalc() {
        TaxableYears = TaxYearsLoader.loadYears(); 
        if (TaxableYears.isEmpty()) {
            throw new TaxDataLoadFailException("No tax data found!");
        }
    }
    
    /**
     * Set the filing type for the FedTaxCalc object.
     * @param status Enum that represends the filing type to use for taxes.
     */
    public void setFilingStatus(FilingType status) {
        FilingStatus = status;
    }
    
    /**
     * Set the year to calculate taxes for. 
     * @param year The integer representation of the year to use. 
     */
    public void setTaxYear(int year) throws TaxCalculatorException {
        currentYear = TaxableYears.get(year);
        
        if (currentYear == null) {
            currentYear = TaxableYears.values().iterator().next();
            String msg = String.format("Year %d's data could not be found, using %d instead.",
                    year, currentYear.getYear());
            throw new TaxCalculatorException(msg);
        }
    }
    
    /**
     * Get the current year that is set to calculate taxes for. 
     * @return an integer that is the year that is currently set. 
     */
    public int getTaxYear() {
        return currentYear.getYear();
    }
        
    /**
     * Calculate taxes for the currently set year and filing status. 
     * @return a double representing the taxes to be paid. 
     * @throws TaxCalculatorException Thrown if the year or filing status is not set. 
     */
    public double calcTaxes(double TaxableIncome) throws TaxCalculatorException {
        double taxes;
        if (FilingStatus == null) {
            String msg = String.format("Filing status not set!");
            throw new TaxCalculatorException(msg);
        } else if (currentYear == null) {
            String msg = String.format("Tax year not set!");
            throw new TaxCalculatorException(msg);
        } else {
            taxes = currentYear.CalculateTaxes(FilingStatus, TaxableIncome);
        }
        return taxes;
    }
}

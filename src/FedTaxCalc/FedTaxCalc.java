package FedTaxCalc;

import FedTaxCalc.Loaders.TaxYearsLoader;
import java.util.HashMap;

/**
 * A tac calculator object that return the amount of U.S Federal Income tax that
 * must be paid on a certain amount of taxable income. 
 * @author Ramin
 */
public class FedTaxCalc {
    FilingType FilingStatus;
    double TaxableIncome;
    TaxYear currentYear;
    HashMap<Integer,TaxYear> TaxableYears;
    
    /**
     * Create a new FedTaxCalc object which can be used to calculate taxes. 
     */
    public FedTaxCalc() {
        TaxableYears = TaxYearsLoader.loadYears(); 
        //FATAL: couldn't load any years, stop executing...
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
    public void setTaxYear(int year) {
        currentYear = TaxableYears.get(year);
        
        if (currentYear == null) {
            currentYear = TaxableYears.values().iterator().next();
            //throw exception to notify user/something
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
     * Sets the taxable income that taxes will be calculated from. 
     * @param income amount of income that is to be taxed on. 
     */
    public void setTaxableIncome(double income) {
        TaxableIncome = income;
    }
    
    /**
     * Calculate taxes for the currently set year and filing status. 
     * @return a double representing the taxes to be paid. 
     */
    public double calcTaxes() {
        double taxes;
        if (FilingStatus == null) {
            //FIX: throw an exception if the filing status or year is not set!
            taxes = -1.0;
        } else {
            taxes = currentYear.CalculateTaxes(FilingStatus, TaxableIncome);
        }
        return taxes;
    }
}

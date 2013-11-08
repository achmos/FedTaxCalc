package FedTaxCalc;

import FedTaxCalc.Loaders.TaxYearsLoader;
import java.util.HashMap;

/**
 *
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
        TaxYearsLoader yearsloader = new TaxYearsLoader();
        TaxableYears = yearsloader.loadYears(); 
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
            int size = TaxableYears.size();
            TaxYear[] yearArr = TaxableYears.values().toArray(new TaxYear[0]) ;
            currentYear = yearArr[size - 1];
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
     * 
     * @param income 
     */
    public void setTaxableIncome(double income) {
        TaxableIncome = income;
    }
    
    /**
     * 
     * @return 
     */
    public double calcTaxes() {
        if (FilingStatus == null) {
            //FIX: throw an exception if the filing status or year is not set!
            return -1.0;
        } else {
            return currentYear.CalculateTaxes(FilingStatus, TaxableIncome);
        }
    }
}

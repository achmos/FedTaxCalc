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
    
    public FedTaxCalc() {
        TaxYearsLoader yearsloader = new TaxYearsLoader();
        TaxableYears = yearsloader.loadYears(); 
    }
    
    public void setFilingStatus(FilingType status) {
        FilingStatus = status;
    }
    
    public void setTaxYear(int year) {
        currentYear = TaxableYears.get(year);
        
        if (currentYear == null) {
            int size = TaxableYears.size();
            TaxYear[] yearArr = TaxableYears.values().toArray(new TaxYear[0]) ;
            currentYear = yearArr[size - 1];
            //throw exception to notify user
        }
    }
    
    public void setTaxableIncome(double income) {
        TaxableIncome = income;
    }
    
    public double calcTaxes() {
        //FIX: throw an exception if the filing status or year is not set!
        return currentYear.CalculateTaxes(FilingStatus, TaxableIncome);
    }
}

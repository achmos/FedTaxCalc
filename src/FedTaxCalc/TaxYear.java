package FedTaxCalc;

import java.util.EnumMap;

/**
 *
 * @author Ramin
 */
public class TaxYear {
    private int year;
    private EnumMap<FilingType, TaxYearFilingType> FilingTypes;
    
    public int getYear() {
        return year;
    }
    
    public TaxYear(int y, EnumMap<FilingType, TaxYearFilingType> yearTypes) {
        FilingTypes = yearTypes;
    }
    
    public double CalculateTaxes(FilingType FilingStatus, double TaxableIncome) {
        TaxYearFilingType TaxFilingType = FilingTypes.get(FilingStatus);
        return TaxFilingType.CalculateTaxes(TaxableIncome);
    }
}

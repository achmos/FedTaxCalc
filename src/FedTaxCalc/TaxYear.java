package FedTaxCalc;

import FedTaxCalc.Exceptions.TaxDataLoadFailException;
import java.util.EnumMap;

/**
 * Holds all the tax brackets and percentages for all the tax filing types for a
 * year. 
 * @author Ramin
 */
public class TaxYear {
    private int year;
    private EnumMap<FilingType, TaxYearFilingType> FilingTypes;
    
    /**
     * Create a new TaxYear Object for the given year with the tax filing types 
     * in the EnumMap.
     * @param year The year to represent
     * @param yearTypes an EnumMap that is index by a FilingType and returns 
     * TaxYearFilingType objects. 
     */
    public TaxYear(int year, EnumMap<FilingType, TaxYearFilingType> yearTypes) {
        FilingTypes = yearTypes;
        this.year =  year;
    }
    
    /**
     * Returns the Year this TaxYear object represents.
     * @return the integer representation of the year. 
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Calculates the taxes for this year given the FilingType and the taxable 
     * income. 
     * @param FilingStatus the enum type of FilingType to use.
     * @param TaxableIncome The amount of taxable income for this year. 
     * @return The amount of taxes that must be paid this year.s 
     * @throws TaxDataLoadFailException Thrown if the filing type data could not be found.
     */
    public double CalculateTaxes(FilingType FilingStatus, double TaxableIncome) {
        if (FilingTypes.containsKey(FilingStatus)) {
            TaxYearFilingType TaxFilingType = FilingTypes.get(FilingStatus);
            return TaxFilingType.CalculateTaxes(TaxableIncome);
        } else {
            String msg = String.format("Data for %s filing type for %d could not be found!",
                    FilingStatus.name(), this.year);
            throw new TaxDataLoadFailException(msg);
        }
    }
}

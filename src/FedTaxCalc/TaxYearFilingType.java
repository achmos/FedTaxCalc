package FedTaxCalc;

import java.util.List;

/**
 * Holds the tax brackets and their percentages for particular filing type of a 
 * tax year. 
 * @author Ramin
 */
public class TaxYearFilingType {
    private List<Integer> TaxBrackets;
    private List<Float> Percentages;
    
    /**
     * Create a new TaxYearFilingType object with the given tax brackets and 
     * percentages. The integers stored in the brackets list are the lower 
     * limits of each tax bracket. The percentages in the second list must 
     * correspond exactly to the brackets list. 
     * 
     * @param brackets a list of the lower limits of each bracket in order. 
     * @param percents the percentages of each bracket represented in the 
     * bracket list. 
     */
    public TaxYearFilingType(List<Integer> brackets, List<Float> percents) {
        TaxBrackets = brackets;
        Percentages = percents;
    }
    
    /**
     * Calculate taxes based on the taxable income given. 
     * @param TaxableIncome the amount of money that is taxable income. 
     * @return the amount of taxes that must be paid for this year and filing type. 
     */
    public double CalculateTaxes(double TaxableIncome) {
        double diff, tax, total = 0;
        
        for (int i = 0; i < TaxBrackets.size(); i++) {
            if (i == TaxBrackets.size() - 1) {
                //we have a income that is in the highest tax bracket
                diff = TaxableIncome - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
            } else if (TaxableIncome < TaxBrackets.get(i + 1)) {
                //we are on the bracket that contains the income amount given
                diff = TaxableIncome - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
                break;
            } else {
                //we are on a bracket that does not contain our income amount.
                diff = TaxBrackets.get(i + 1) - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
            }
        }
        
        return Math.round(total); //round up to the nearest dollar. 
    }
}

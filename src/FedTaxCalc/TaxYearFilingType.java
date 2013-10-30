package FedTaxCalc;

import java.util.ArrayList;

/**
 *
 * @author Ramin
 */
public class TaxYearFilingType {
    private ArrayList<Integer> TaxBrackets;
    private ArrayList<Float> Percentages;
    
    public TaxYearFilingType(ArrayList<Integer> brackets, ArrayList<Float> percents) {
        TaxBrackets = brackets;
        Percentages = percents;
    }
    
    public double CalculateTaxes(double TaxableIncome) {
        double diff, tax, total = 0;
        
        for (int i = 0; i < TaxBrackets.size(); i++) {
            if (i == TaxBrackets.size() - 1) {
                diff = TaxableIncome - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
            } else if (TaxableIncome < TaxBrackets.get(i + 1)) {
                diff = TaxableIncome - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
                break;
            } else {
                diff = TaxBrackets.get(i + 1) - TaxBrackets.get(i);
                tax = diff * Percentages.get(i);
                total += tax;
            }
        }
        
        return Math.round(total);
    }
}

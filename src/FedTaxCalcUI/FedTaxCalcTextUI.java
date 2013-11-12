package FedTaxCalcUI;
import FedTaxCalc.Exceptions.TaxCalculatorException;
import FedTaxCalc.Exceptions.TaxCalculatorYearException;
import FedTaxCalc.FedTaxCalc;
import FedTaxCalc.FilingType;
import java.util.Scanner;

/**
 * A text based user interface to the federal tax calculator. 
 * @author Ramin
 */
public class FedTaxCalcTextUI {
    private Scanner sc;
    private FedTaxCalc calculator;

    /**
     * Construct a new Text UI for the Tax Calculator. 
     */
    public FedTaxCalcTextUI() {
        sc = new Scanner(System.in);
        calculator = new FedTaxCalc();
    }
    
    /**
     * Main UI processing.
     */
    public void run() {
        int year; 
        char choice; 
        double income; 
        double taxes;
        
        System.out.println("Welcome to U.S. Federal Tax Calculater by Ramin Tawakuli.");
        
        year = this.getYear();
        this.getFilingType();
        
        do {            
            System.out.println("\nDo you want to use these settings (Y/N): ");
            System.out.printf("Year: %d\n", year);
            System.out.printf("Filing Type: %s\n>:", calculator.getFilingType().toString());
            
            if (!this.getYesOrNo()) {
                do {
                    System.out.println("\nDo you want to use the same year (Y/N): ");
                    System.out.printf("Year: %d\n>:", year);
                
                    if (!this.getYesOrNo()) {
                        year = this.getYear();
                    }
                
                    System.out.println("\nDo you want to use the same filing status (Y/N): ");
                    System.out.printf("Filing Type: %s\n>:", calculator.getFilingType().toString());
                
                    if (!this.getYesOrNo()) {
                        this.getFilingType();
                    }
                
                    System.out.println("\nDo you want to use these settings (Y/N): ");
                    System.out.printf("Year: %d\n", year);
                    System.out.printf("Filing Type: %s\n>:", calculator.getFilingType().toString());
                } while (!this.getYesOrNo());
            }
            
            System.out.printf("\nPlease enter your taxable income for the year entered: ");
            income = sc.nextDouble();
            
            try {
                taxes = calculator.calcTaxes(income);
                System.out.printf("\nYour taxes for the year %d with an income of %f is %f\n", year, income, taxes);
            } catch (TaxCalculatorException ex) {
                System.out.println(ex.getMessage());
            }
            
            System.out.printf("\nPress \'Q\' followed by enter to quit or any other key to continue.\n>:");
            choice = sc.next().charAt(0);
        } while (Character.toUpperCase(choice) != 'Q');
    }
    
    /**
     * Obtains a yes or no answer from the user. 
     * @return true if yes, false if no. 
     */
    public boolean getYesOrNo() {
        char choice = sc.next().charAt(0);
        if (Character.toUpperCase(choice) == 'N') {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Pole the user for the year they want for the calculator. 
     * @return an int representing the year entered. 
     */
    public int getYear() {
        int year;
        System.out.printf("\nPlease enter a tax year: ");
        year = sc.nextInt();
            
        try {
            calculator.setTaxYear(year);
        } catch (TaxCalculatorYearException ex) {
            System.out.println(ex.getMessage());
            year = ex.getNewYear();
        }
        
        return year;
    }
    
    /**
     * Pole the user for the filing type for the calculator. 
     */
    public void getFilingType() {
        int type;
        boolean validType = false;
        
        do {
            System.out.println("\nPlease enter a filing type: ");
            System.out.println("1) Single");
            System.out.println("2) Married Filing Jointly / Widowed");
            System.out.println("3) Married Filing Separatly");
            System.out.println("4) Head of Household");
            System.out.printf(">: ");
            type = sc.nextInt();
            
            switch (type) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                    FilingType [] types = FilingType.values();
                    calculator.setFilingStatus(types[type - 1]);
                    validType = true;
                    break;
                default:
                    System.out.println("That is not a valid selection, select 1 - 4.");
            }
        } while (!validType);
    }
    
    /**
     * Main program entry point. 
     * @param args 
     */
    public static void main(String [] args) {
        FedTaxCalcTextUI ui = new FedTaxCalcTextUI();
        ui.run();
    }
}
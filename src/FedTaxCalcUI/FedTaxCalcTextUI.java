package FedTaxCalcUI;
import FedTaxCalc.FedTaxCalc;
import FedTaxCalc.FilingType;
import java.util.Scanner;

/**
 * A simple text based user interface to the federal tax calculator. 
 * @author Ramin
 */
public class FedTaxCalcTextUI {
    public static void main(String [] args) {
        char choice; 
        int year, type;
        double income; 
        double taxes;
        boolean validType = false;
        
        Scanner sc = new Scanner(System.in);
        FedTaxCalc calculator = new FedTaxCalc();
        
        do {
            System.out.printf("\nPlease enter a tax year: ");
            year = sc.nextInt();
            calculator.setTaxYear(year);
            
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
            
            System.out.printf("\nPlease enter your taxable income for the year entered: ");
            income = sc.nextDouble();
            calculator.setTaxableIncome(income);
            
            taxes = calculator.calcTaxes();
            System.out.printf("\nYour taxes for the year %d with an income of %f is %f\n", year, income, taxes);
            
            System.out.printf("\nPress \'Q\' followed by enter to quit or any other key to continue.\n>:");
            choice = sc.next().charAt(0);
        } while (Character.toUpperCase(choice) != 'Q');
    }
}
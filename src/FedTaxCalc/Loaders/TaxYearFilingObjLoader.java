package FedTaxCalc.Loaders;

import FedTaxCalc.TaxYearFilingType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaxYearFilingObjLoader {
    /**
     * Loads the tax brackets for a particular year and tax filing type. 
     * @param filename String name of the file that contains the tax information 
     * needed. 
     * @return A TaxYearFilingType object with the necessary bracket information
     */
    public static TaxYearFilingType LoadYearFilingType(String filename) {
        BufferedReader Yearfile;
        TaxYearFilingType filing = null;
        ArrayList<Integer> brackets = new ArrayList<>();
        ArrayList<Float> percents = new ArrayList<>();
        String Delim = "[ \t\n\f\r]";
        String line;
        
        try {
            Yearfile = new BufferedReader( new FileReader(filename) );
            
            while (Yearfile.ready()) {
                line = Yearfile.readLine();
                //parse the line into its two parts
                String brak[] = line.split(Delim);
                
                //lower limit of bracket is first, percentage is second. 
                brackets.add(Integer.valueOf(brak[1]));
                percents.add(Float.valueOf(brak[0]));
            }
                
            filing = new TaxYearFilingType(brackets, percents);
        } catch (IOException ex) {
            //FIX: change to a logger? 
            System.err.println(ex.getMessage());
        }
        
        return filing; 
    }
}

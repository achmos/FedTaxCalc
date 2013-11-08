package FedTaxCalc.Loaders;

import FedTaxCalc.TaxYearFilingType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaxYearFilingObjLoader {
    /**
     * 
     * @param filename
     * @return 
     */
    public static TaxYearFilingType LoadYearFiling(String filename) {
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
                String brak[] = line.split(Delim);
                brackets.add(Integer.valueOf(brak[1]));
                percents.add(Float.valueOf(brak[0]));
            }
                
            filing = new TaxYearFilingType(brackets, percents);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return filing; 
    }
}

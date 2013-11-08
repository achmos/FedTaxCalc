package FedTaxCalc.Loaders;

import FedTaxCalc.DirectoryManager;
import FedTaxCalc.FilingType;
import FedTaxCalc.TaxYear;
import FedTaxCalc.TaxYearFilingType;
import java.nio.file.Path;
import java.util.EnumMap;

/**
 *
 * @author Ramin
 */
public class TaxYearObjLoader { 
    /**
     * 
     * @param y
     * @param pathdir
     * @return 
     */
    public TaxYear LoadYear(int y, String pathdir) {
        EnumMap<FilingType, TaxYearFilingType> YearFilings;
        YearFilings = new EnumMap<>(FilingType.class);
        TaxYear year;
        TaxYearFilingType NewYearFiling;
        DirectoryManager dirMan = new DirectoryManager(pathdir);
        
        while (dirMan.hasNext()) {
            Path entry = dirMan.getNext();
                
            NewYearFiling = TaxYearFilingObjLoader.LoadYearFiling(entry.toString());
            String filename = entry.getFileName().toString();
            int i = filename.indexOf("_");
            int j = filename.indexOf(".");
            if (j == -1 ) {
                j = filename.length();
            }
            String type = filename.substring( i + 1 , j );
            YearFilings.put(FilingType.valueOf(type), NewYearFiling);
        }
        
        year = new TaxYear(y, YearFilings);
        return year;
    } 
}

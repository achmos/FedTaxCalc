package FedTaxCalc.Loaders;

import FedTaxCalc.DirectoryManager;
import FedTaxCalc.TaxYear;
import java.nio.file.Path;
import java.util.HashMap;

/**
 *
 * @author Ramin
 */
public class TaxYearsLoader {
    public HashMap<Integer,TaxYear> loadYears() {
        TaxYear NewYear;
        HashMap<Integer,TaxYear> years = new HashMap<>();
        TaxYearObjLoader ObjLoader = new TaxYearObjLoader();
        
        String rootdir = System.getProperties().getProperty("user.dir");
        String seperator = System.getProperties().getProperty("file.separator");
        String sdir = rootdir + seperator + "data";
        DirectoryManager dirMan = new DirectoryManager(sdir);
        
        while (dirMan.hasNext()) {        
            Path entry = dirMan.getNext();
            Integer year = Integer.valueOf(entry.getFileName().toString());
            NewYear = ObjLoader.LoadYear(year, entry.toString());
            years.put(year, NewYear);
        }
        
        return years;
    }
}

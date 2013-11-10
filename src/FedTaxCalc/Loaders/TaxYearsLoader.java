package FedTaxCalc.Loaders;

import FedTaxCalc.DirectoryManager;
import FedTaxCalc.TaxYear;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Loads all the years that can be used for calculating taxes. More Tax years 
 * can be added and the loader will be able to load them as well. 
 * @author Ramin
 */
public class TaxYearsLoader {
    /**
     * Loads all the TaxYears and returns them to the caller.
     * @return A hashmap of integers year to TaxYear objects. 
     */
    public static HashMap<Integer,TaxYear> loadYears() {
        TaxYear NewYear;
        HashMap<Integer,TaxYear> years = new HashMap<>();
        
        //get the current directory
        String rootdir = System.getProperties().getProperty("user.dir");
        //get the file seperator for this OS were running on. 
        String seperator = System.getProperties().getProperty("file.separator");
        //create the path to the yearly tax data
        String sdir = rootdir + seperator + "data";
        DirectoryManager dirMan = new DirectoryManager(sdir);
        
        while (dirMan.hasNext()) {        
            //get the next item in the directory
            Path entry = dirMan.getNext();
            //convert the name of the directory to the integer year
            Integer year = Integer.valueOf(entry.getFileName().toString());
            
            //load a new TaxYear obj and add it to the hashmap by year.
            NewYear = TaxYearObjLoader.LoadYear(year, entry.toString());
            years.put(year, NewYear);
        }
        
        return years;
    }
}

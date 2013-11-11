package FedTaxCalc.Loaders;

import FedTaxCalc.FilingType;
import FedTaxCalc.TaxYear;
import FedTaxCalc.TaxYearFilingType;
import java.nio.file.Path;
import java.util.EnumMap;

/**
 * A loader class that loads a single tax year's information for runtime use. 
 * @author Ramin
 */
class TaxYearObjLoader { 
    /**
     * Loads a tax year object given the integer year and the directory path.
     * @param year the year that is being loaded. 
     * @param pathdir string that is the path to the year's data on the disk.
     * @return a tax year object with all the tax data loaded, or null if no 
     * data could be found for the year provided.
     */
    public static TaxYear LoadYear(int year, String pathdir) {
        TaxYear newYear;
        TaxYearFilingType NewYearFiling;
        EnumMap<FilingType, TaxYearFilingType> YearFilings = new EnumMap<>(FilingType.class);
        DirectoryManager dirMan = new DirectoryManager(pathdir);
        
        while (dirMan.hasNext()) {
            Path entry = dirMan.getNext();
            NewYearFiling = TaxYearFilingObjLoader.LoadYearFilingType(entry.toString());
            
            //extract the filing type from the filename. 
            String filename = entry.getFileName().toString();
            int i = filename.indexOf("_");
            int j = filename.indexOf(".");
            if (j == -1 ) { //incase on mac, no file extension...
                j = filename.length();
            }
            String type = filename.substring( i + 1 , j );
            YearFilings.put(FilingType.valueOf(type), NewYearFiling);
        }
        if (!YearFilings.isEmpty()) {
            newYear = new TaxYear(year, YearFilings);
            return newYear;
        } else {
            return null;
        }
    } 
}

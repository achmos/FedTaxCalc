package FedTaxCalc;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * An interface class that abstracts away the Java NIO libraries for accessing 
 * directories. 
 * @author Ramin
 */
public class DirectoryManager {
    private DirectoryStream<Path> stream;
    private Iterator<Path> itr;
    
    /**
     * Create a new DirectoryManager that accesses the directory specified in 
     * the string 'pathname'
     * @param pathname A string that contains the absolute path of the directory
     * to access.
     */
    public DirectoryManager(String pathname) {
        Path dir = Paths.get(pathname);
        
        try {
            stream = Files.newDirectoryStream(dir);
            itr = stream.iterator();
        } catch (IOException ex) {
            //FIX: if not command line program, what happens here? a logger? 
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Get the next element in the Directory. 
     * @return the next item in the directory, represented by a Path object. 
     */
    public Path getNext() {
        return itr.next();
    }
    
    /**
     * Checks to see if there is anything left in the directory that hasn't been
     * accessed yet. 
     * @return true if there are elements to access in the directory. false if 
     * there are not or if the DirectoryManager is not accessing a directory. 
     */
    public boolean hasNext() {
        if (itr != null) {
            return itr.hasNext();
        } else {
            return false;
        }
    }
}

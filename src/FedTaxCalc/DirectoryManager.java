package FedTaxCalc;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 *
 * @author Ramin
 */
public class DirectoryManager {
    private DirectoryStream<Path> stream;
    private Iterator<Path> itr;
            
    public DirectoryManager(String pathname) {
        Path dir = Paths.get(pathname);
        
        try {
            stream = Files.newDirectoryStream(dir);
            itr = stream.iterator();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Path getNext() {
        return itr.next();
    }
    
    public boolean hasNext() {
        if (itr != null) {
            return itr.hasNext();
        } else {
            return false;
        }
    }
}

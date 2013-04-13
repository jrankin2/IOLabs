package lab4.FileService;

import java.io.IOException;
import java.util.List;

/**
 * Defines a file writing strategy
 * @author jrankin2
 */
public interface FileWriterStrategy {
    public abstract boolean writeFile(List objects) throws IOException;//returns success bool
    
    public abstract void setAppend(boolean append);
    public abstract boolean doesAppend();
}

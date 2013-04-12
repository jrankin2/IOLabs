package lab4.FileService;

import java.io.IOException;
import java.util.List;

/**
 * Defines a file reading strategy
 * @author jrankin2
 */
public interface FileReaderStrategy {
    public abstract List readFile() throws IOException;
}

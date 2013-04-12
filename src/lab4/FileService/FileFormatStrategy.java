package lab4.FileService;

import java.util.List;

/**
 * Defines a strategy to encode and decode file data.
 * @author jrankin2
 */
public interface FileFormatStrategy {
    /**
     * Takes an object containing data and encodes it to a list of file lines.
     * @param data object to encode
     * @return list of file lines
     */
    public abstract List encode(Object data);//
    
    /**
     * Takes a List containing line data and decodes it to an object.
     * @param data file lines
     * @return object with decoded data in it. See implementation documentation<br>
     * for more details.
     */
    public abstract Object decode(List data);
}

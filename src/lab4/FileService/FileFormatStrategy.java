package lab4.FileService;

import java.util.List;

/**
 * Defines a strategy to encode and decode file data.
 * @author jrankin2
 */
public interface FileFormatStrategy<EncodedObject, DecodedObject> {
    /**
     * Takes a List of DecodedObjects and encodes it to a list of EncodedObjects.
     * @param data object to encode
     * @return list of file lines
     */
    public abstract List<EncodedObject> encode(List<DecodedObject> data);//
    
    /**
     * Takes a List of line data and decodes it to an object.
     * @param data file lines
     * @return object with decoded data in it. See implementation documentation<br>
     * for more details about what is returned.
     */
    public abstract List<DecodedObject> decode(List<EncodedObject> data);
}

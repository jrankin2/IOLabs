package lab4.FileService;

import java.util.List;

/**
 * Defines a strategy to encode and decode file data.
 * @author jrankin2
 */
public interface FileFormatStrategy<EncodedObject, DecodedObject> {
    /**
     * Takes a List of DecodedObjects and encodes it to a List of EncodedObjects.
     * @param data List of DecodedObjects to encode
     * @return List of EncodedObjects (e.g. Strings in the case of file handling)
     */
    public abstract List<EncodedObject> encode(List<DecodedObject> data);//
    
    /**
     * Takes a List EncodedObjects and decodes it to a List of DecodedObjects.
     * @param data List of EncodedObjects to decode
     * @return List of DecodedObjects
     */
    public abstract List<DecodedObject> decode(List<EncodedObject> data);
}

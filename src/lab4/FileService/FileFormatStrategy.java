package lab4.FileService;

import java.util.List;

/**
 * Defines a strategy to encode and decode file data. I decided to use lists in
 * this strategy so that implementations can do things that assume they're being
 * passed a complete file, such as a (more complicated) CSV implementation that
 * extracts the headers and maps them to each column on every line - or an impl.
 * that sorts the file as well as encodes/decodes it, for example.
 * 
 * Cons:
 * *When used outside the context of the FileService, a List still needs to be passed,
 * making it less useful(?) at encoding/decoding singular objects.
 * 
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

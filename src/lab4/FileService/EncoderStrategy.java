
package lab4.FileService;

import java.util.List;

public interface EncoderStrategy<EncodedObject,DecodedObject> {
    /**
     * Takes a List of DecodedObjects and encodes it to a List of EncodedObjects.
     * @param data List of DecodedObjects to encode
     * @return List of EncodedObjects (e.g. Strings in the case of file handling)
     */
    public abstract List<EncodedObject> encode(List<DecodedObject> data);//
    
}

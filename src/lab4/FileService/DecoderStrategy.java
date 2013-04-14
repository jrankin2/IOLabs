package lab4.FileService;

import java.util.List;

/**
 *
 * @author Joe Rankin
 */
public interface DecoderStrategy<EncodedObject, DecodedObject> {
    /**
     * Takes a List EncodedObjects and decodes it to a List of DecodedObjects.
     * @param data List of EncodedObjects to decode
     * @return List of DecodedObjects
     */
    public abstract List<DecodedObject> decode(List<EncodedObject> data);
}

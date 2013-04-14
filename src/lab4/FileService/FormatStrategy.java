package lab4.FileService;

import java.util.List;

/**
 * Extends both encoder and decoder to provide an interface for complete format
 * handling implementations.
 * 
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
public interface FormatStrategy<EncodedObject, DecodedObject> 
                          extends EncoderStrategy<EncodedObject, DecodedObject>,
                                  DecoderStrategy<EncodedObject, DecodedObject>{
    
    //public abstract List<EncodedObject> encode(List<DecodedObject> data);//
    
    
}

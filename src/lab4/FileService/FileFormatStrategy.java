package lab4.FileService;

import java.util.List;

/**
 * Defines a strategy to encode and decode file data.
 * @author jrankin2
 */
public interface FileFormatStrategy {
    public abstract List encode();
    public abstract List decode(List data);
}

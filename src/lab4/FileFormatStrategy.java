package lab4;

/**
 * Defines a strategy to encode and decode file data.
 * @author jrankin2
 */
interface FileFormatStrategy {
    public abstract String[] encodeToLines();
    public abstract String[] encodeToObject();
}

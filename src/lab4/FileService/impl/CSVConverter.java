package lab4.FileService.impl;

import java.util.List;
import lab4.FileService.FileFormatStrategy;

/**
 * @author Joe
 */
public class CSVConverter implements FileFormatStrategy{

    @Override
    public List encode(Object data) {
        
        return null;
    }

    @Override
    public Object decode(List data) {
        return null;
    }
    
    private static class CSVRow{
        
    }

}

package lab4.FileService.impl;

import java.util.ArrayList;
import java.util.List;
import lab4.FileService.FileFormatStrategy;

/**
 * @author Joe
 */
public class CSVConverter implements FileFormatStrategy<String, String[]>{
    
    public CSVConverter(){
    }
    
    
    @Override
    public List<String> encode(List<String[]> data) {
        List<String> encodedLines = new ArrayList();
        StringBuilder sb;
        
        for (String[] lineCSVData : data) {
            sb = new StringBuilder();
            for(int i = 0; i < lineCSVData.length; i++) {
                sb.append(lineCSVData[i]);
                if(i != lineCSVData.length - 1) sb.append(",");
                
            }
        }
        
        return null;
    }
    
    /**
     * Decode a List containing CSV records (file lines) into a list of Strings.
     * **Don't know if I should use List<String> for data param...
     * 
     * @param data list containing file lines
     * @return List<String[]> containing CSV data fields
     */
    @Override
    public List<String[]> decode(List<String> data) {
        String lineData[];
        List<String[]> fileLineData = new ArrayList<String[]>();
        
        for (Object line : data) {
            lineData = ((String)line).split(",");
            fileLineData.add(lineData);
        }
        
        return fileLineData;
    }
    

}

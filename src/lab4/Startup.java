/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lab4.FileService.*;
import lab4.FileService.impl.*;

/**
 * Just a class demonstrating the FileService.
 * See also - ContactConversionSample
 * @author jrankin2
 */
public class Startup {
    
    public static void main(String[] args) {
        FileReaderStrategy tfr = new TextFileReader("src/fsTest.txt");
        FileWriterStrategy tfw = new TextFileWriter("src/fsTest.txt", false);
        FormatStrategy csvc = new CSVConverter();
        List<String[]> lines = new ArrayList<String[]>();
        lines.add(new String[] {"hello", "world"});
        lines.add(new String[] {"world", "hello"});
        
        FileService<String[]> fs = new FileService(tfr, tfw, csvc, csvc);
        try{
            if(fs.writeFile(lines)){//if writing was successful
                List<String[]> csvData = fs.readFile();
                for (String[] row : csvData) {
                    System.out.println(Arrays.toString(row));
                }
            }
            
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
    }
    
}

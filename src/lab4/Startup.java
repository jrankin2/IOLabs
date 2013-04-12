/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lab4.FileService.*;
import lab4.FileService.impl.*;

/**
 *
 * @author bitstudent
 */
public class Startup {
    
    public static void main(String[] args) {
        FileReaderStrategy tfr = new TextFileReader("src/fsTest.txt");
        FileWriterStrategy tfw = new TextFileWriter("src/fsTest.txt", false);
        CSVConverter csvc = new CSVConverter();
        List<String[]> lines = new ArrayList<String[]>();
        lines.add(new String[] {"hello", "world"});
        lines.add(new String[] {"world", "hello"});
        
        FileService fs = new FileService(tfr, tfw, csvc, csvc);
        try{
            fs.writeFile(lines);
            System.out.println(fs.readFile());
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
    }
    
}

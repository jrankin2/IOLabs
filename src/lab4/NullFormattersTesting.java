/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lab4.FileService.FileReaderStrategy;
import lab4.FileService.FileService;
import lab4.FileService.FileWriterStrategy;
import lab4.FileService.FormatStrategy;
import lab4.FileService.impl.NullTextFormatter;
import lab4.FileService.impl.TextFileReader;
import lab4.FileService.impl.TextFileWriter;

/**
 *
 * @author Joe Rankin
 */
public class NullFormattersTesting {
    public static void main(String[] args) {
        FileReaderStrategy<String> tfr = new TextFileReader("src/fsNullFormatTest.txt");
        FileWriterStrategy<String> tfw = new TextFileWriter("src/fsNullFormatTest.txt", false);
        FormatStrategy<String, String> ntf = new NullTextFormatter();
        List<String> lines = new ArrayList<String>();
        lines.add("hello, world!");
        lines.add("how are you?");
        
        FileService<String, String> fs = new FileService<String, String>(tfr, tfw, ntf, ntf);
        
        try{
            if(fs.writeFile(lines)){//if writing was successful
                List<String> lineData = fs.readFile();
                for (String line : lineData) {
                    System.out.println(line);
                }
            }
            
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
        
    }
}

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
        FileWriterStrategy tfw = new TextFileWriter("src/fsTest.txt", true);
        
        List lines = new ArrayList();
        lines.add("hello");
        lines.add("world");
        
        FileService fs = new FileService(tfr, tfw, null, null);
        try{
            fs.writeFile(lines);
            System.out.println(fs.readFile());
        } catch(IOException ioe){
            System.out.println("ioe = " + ioe.getMessage());
        }
        
        
        
        
    }
    
}

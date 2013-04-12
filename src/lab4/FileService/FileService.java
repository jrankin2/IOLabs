/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.FileService;

import java.beans.XMLEncoder;
import java.io.File;


/**
 *
 * @author jrankin2
 */
public class FileService {
    FileReaderStrategy fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy fileWriter;//TextFileWriter/BinaryFileWriter
    File readFile;
    File writeFile;
    FileFormatStrategy fileReaderFormat;
    FileFormatStrategy fileWriterFormat;
    
    public FileService(){
        
    }
    
    public boolean writeFile(){
        XMLEncoder encoder;
        return true;
    }
    
    public boolean writeFileFromObject(){
        return true;
    }
    
    public Object readFileToObject(){
        return null;
    }
    
    public String[] readFileLines(){
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}

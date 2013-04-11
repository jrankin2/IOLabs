/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.nio.file.Path;

/**
 *
 * @author jrankin2
 */
public class FileService {
    FileReaderStrategy fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy fileWriter;//TextFileWriter/BinaryFileWriter
    Path fileReadPath;
    Path fileWritePath;
    FileFormatStrategy fileReaderFormat;
    FileFormatStrategy fileWriterFormat;
    
    public FileService(){
        
    }
    
    public boolean writeFileFromLines(String[] lines){
        return true;
    }
    
    public boolean writeFileFromObject(Object fileData){
        return true;
    }
    
    public Object readFileToObject(){
        return null;
    }
    
    public String[] readFileLines(){
        return null;
    }
}

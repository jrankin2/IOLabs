/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.FileService;

import java.io.File;
import java.io.IOException;
import java.util.List;


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

    public FileService(FileReaderStrategy fileReader, FileWriterStrategy fileWriter, FileFormatStrategy fileReaderFormat, FileFormatStrategy fileWriterFormat) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.fileReaderFormat = fileReaderFormat;
        this.fileWriterFormat = fileWriterFormat;
    }
    
    public boolean writeFile(List objects) throws IOException{
        return fileWriter.writeFile(objects);
    }
    
    
    public Object readFile() throws IOException{
        return fileReader.readFile();
    }
    
    public static void main(String[] args) {
        
    }
}

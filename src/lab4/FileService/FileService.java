/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.FileService;

import java.io.IOException;
import java.util.List;
import lab4.Startup;


/**
 * File service that reads and writes to files using the specified formatter. If
 * no formatter is provided, it assumes it is writing to / reading from files
 * solely with Lists of Strings. Formatter implementations provide their own 
 * return types and parameter types, so the type of list returned by readFile
 * and the type of list needed to be passed to writeFile varies - be careful.
 * @author jrankin2
 */
public class FileService {
    FileReaderStrategy fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy fileWriter;//TextFileWriter/BinaryFileWriter
    FileFormatStrategy fileReaderFormat;
    FileFormatStrategy fileWriterFormat;

    public FileService(FileReaderStrategy fileReader, FileWriterStrategy fileWriter, FileFormatStrategy fileReaderFormat, FileFormatStrategy fileWriterFormat) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.fileReaderFormat = fileReaderFormat;
        this.fileWriterFormat = fileWriterFormat;
    }
    
    /**
     * Writes to a file given a List containing objects to encode or file lines<br>
     * depending on whether or not the fileWriterFormat is null.
     * @param objects list of file lines or objects to encode depending if the
     * fileWriterFormat is null or not, respectively.
     * @return success boolean
     * @throws IOException if there's a problem writing to file
     * @throws UnsupportedOperationException when fileWriter is null
     */
    public boolean writeFile(List objects) throws IOException, UnsupportedOperationException{
        if(isWriteable()){
            List<String> encodedLines = fileWriter != null ? fileWriterFormat.encode(objects) : objects;
            return fileWriter.writeFile(encodedLines);
        } else{
            //just return false?
            throw new UnsupportedOperationException("Can't write to (null)");
        }
    }
    
    /**
     * Reads from a file into a List containing decoded objects or file lines
     * depending on whether or not the fileReaderFormat is null.
     * @return List of file lines or list of decoded objects depending on if the
     * fileReaderFormat is null or not.
     * @throws IOException when file reading errors
     * @throws UnsupportedOperationException when fileReader is null
     */
    public List readFile() throws IOException, UnsupportedOperationException{
        if(isReadable()){
            List<String> fileLines = fileReader.readFile();
            return fileReaderFormat != null ? fileReaderFormat.decode(fileLines) : fileLines;
        } else{
            throw new UnsupportedOperationException("Can't read from (null)");
        }
    }

    public FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReaderStrategy fileReader) {
        this.fileReader = fileReader;
    }

    public FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriterStrategy fileWriter) {
        this.fileWriter = fileWriter;
    }

    public FileFormatStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    public void setFileReaderFormat(FileFormatStrategy fileReaderFormat) {
        this.fileReaderFormat = fileReaderFormat;
    }

    public FileFormatStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    public void setFileWriterFormat(FileFormatStrategy fileWriterFormat) {
        this.fileWriterFormat = fileWriterFormat;
    }

    public void setAppend(boolean append) {
        fileWriter.setAppend(append);
    }

    public boolean doesAppend() {
        return fileWriter.doesAppend();
    }
    
    public boolean isWriteable(){
        return fileWriter != null;
    }
    
    public boolean isReadable(){
        return fileReader != null;
    }
    
    
    public static void main(String[] args) {
        Startup.main(args);//requirements, lol
    }
    
}

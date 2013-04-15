/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.FileService;

import java.io.IOException;
import java.util.List;
import lab4.Startup;


/**
 * FileService<T>
 * 
 * File service that reads and writes to files using the specified formatters.
 * Formatters must be of the generic <String,T> if FileService is initialized using
 * generics.
 * 
 * If a formatter is null, it assumes it is writing to / reading from files
 * with Lists of Strings passed/returned.
 * 
 * FileReaderFormat and FileWriterFormat can be null if reading/writing is not
 * needed respectively.
 * 
 * @author jrankin2
 */
public class FileService<E, D>{//<EncodedFormat, DecodedFormat>//viable?
    FileReaderStrategy fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy fileWriter;//TextFileWriter/BinaryFileWriter
    DecoderStrategy fileReaderFormat;
    EncoderStrategy fileWriterFormat;
    
    public FileService(FileHandlerStrategy<E> fileHandler, FormatStrategy<E,D> format){
        fileReader = fileHandler;
        fileWriter = fileHandler;
        fileReaderFormat = format;
        fileWriterFormat = format;
    }

    public FileService(FileReaderStrategy<E> fileReader, 
            FileWriterStrategy<E> fileWriter, 
            DecoderStrategy<E,D> fileReaderFormat,
            EncoderStrategy<E,D> fileWriterFormat) 
    {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.fileReaderFormat = fileReaderFormat;
        this.fileWriterFormat = fileWriterFormat;
    }
    
    /**
     * Writes to a file given a List containing objects to encode or file lines(Strings)<br>
     * depending on whether or not the fileWriterFormat is null.
     * @param objects list of file lines or objects to encode depending if the
     * fileWriterFormat is null or not, respectively.
     * @return success boolean
     * @throws IOException if there's a problem writing to file
     * @throws UnsupportedOperationException when fileWriter is null
     */
    public boolean writeFile(List<D> objects) throws IOException, UnsupportedOperationException{
        if(isWriteable()){
            List<E> encodedLines = fileWriter != null ? fileWriterFormat.encode(objects) : objects;
            return fileWriter.writeFile(encodedLines);
        } else{
            //just return false?
            throw new UnsupportedOperationException("Cannot write to null");
        }
    }
    
    /**
     * Reads from a file into a List containing decoded objects or file lines (Strings)
     * depending on whether or not the fileReaderFormat is null.
     * @return List of file lines or list of decoded objects depending on if the
     * fileReaderFormat is null or not.
     * @throws IOException when file reading errors
     * @throws UnsupportedOperationException when fileReader is null
     */
    public List<D> readFile() throws IOException, UnsupportedOperationException{
        if(isReadable()){
            List<E> fileLines = fileReader.readFile();
            return fileReaderFormat != null ? fileReaderFormat.decode(fileLines) : fileLines;
        } else{
            throw new UnsupportedOperationException("Can't read from null");
        }
    }
    
    public List<E> encode(List<D> data) {
        if(fileWriterFormat == null){
            throw new UnsupportedOperationException("Cannot encode data with null formatter.");
        }
        return fileWriterFormat.encode(data);
    }

    public List<D> decode(List<E> data) {
        if(fileReaderFormat == null){
            throw new UnsupportedOperationException("Cannot decode data with null formatter.");
        }
        return fileReaderFormat.decode(data);
    }
    

    public FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReaderStrategy<E> fileReader) {
        this.fileReader = fileReader;
    }

    public FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriterStrategy<E> fileWriter) {
        this.fileWriter = fileWriter;
    }

    public DecoderStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    public void setFileReaderFormat(DecoderStrategy<E,D> fileReaderFormat) {
        this.fileReaderFormat = fileReaderFormat;
    }

    public EncoderStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    public void setFileWriterFormat(EncoderStrategy<E,D> fileWriterFormat) {
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

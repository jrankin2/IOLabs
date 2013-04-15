/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.FileService;

import java.io.IOException;
import java.util.List;

/**
 * FileService<T>
 * 
 * File service that reads and writes to files using the specified formatters.
 * Generics ensure that data is being encoded/decoded to/from the same types...
 * 
 * If a formatter is null, it assumes it is writing to / reading from files
 * without using a formatter.
 * 
 * FileReaderFormat and FileWriterFormat can be null if reading/writing is not
 * needed. isReadable() and isWritable() return whether
 * 
 * "Thank god for type erasure!"
 *      -No one ever
 * 
 * @author jrankin2
 */
public class FileService<E, D>{//<EncodedFormat, DecodedFormat>//viable?
    FileReaderStrategy<E> fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy<E> fileWriter;//TextFileWriter/BinaryFileWriter
    DecoderStrategy<E,D> fileReaderFormat;
    EncoderStrategy<E,D> fileWriterFormat;
    
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
     * Writes to a file given a List containing objects to encode or file lines
     * @param objects list of objects to encode/write to file
     * @return success boolean
     * @throws IOException if there's a problem writing to file
     * @throws UnsupportedOperationException when fileWriter is null
     */
    public boolean writeFile(List<D> objects) throws IOException, UnsupportedOperationException{
        if(isWriteable() && fileWriterFormat != null){
            List<E> encodedLines = fileWriterFormat.encode(objects);
            return fileWriter.writeFile(encodedLines);
        } else{
            //just return false?
            throw new UnsupportedOperationException("Cannot write to or format with null");
        }
    }
    
    /**
     * Reads from a file into a List containing decoded objects.
     * @return List of file lines or list of decoded objects depending on if the
     * fileReaderFormat is null or not.
     * @throws IOException when file reading errors
     * @throws UnsupportedOperationException when fileReader is null
     */
    public List<D> readFile() throws IOException, UnsupportedOperationException{
        if(isReadable() && fileReaderFormat != null){
            List<E> fileLines = fileReader.readFile();
            return fileReaderFormat.decode(fileLines);
        } else{
            throw new UnsupportedOperationException("Can't read from or format with null");
        }
    }
    
    
    public List<E> encode(List<D> data) {
        if(fileWriterFormat == null){
            throw new UnsupportedOperationException("Cannot encode data with null encoder.");
        }
        return fileWriterFormat.encode(data);
    }

    public List<D> decode(List<E> data) {
        if(fileReaderFormat == null){
            throw new UnsupportedOperationException("Cannot decode data with null decoder.");
        }
        return fileReaderFormat.decode(data);
    }
    

    public FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReaderStrategy<E> fileReader) {
        if(fileReader == null){
            throw new IllegalArgumentException("File Reader cannot be null");
        }
        this.fileReader = fileReader;
    }

    public FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriterStrategy<E> fileWriter) {
        if(fileWriter == null){
            throw new IllegalArgumentException("File Writer cannot be null");
        }
        this.fileWriter = fileWriter;
    }

    public DecoderStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    public void setFileReaderFormat(DecoderStrategy<E,D> fileReaderFormat) {
        if(fileReaderFormat == null){
            throw new IllegalArgumentException("File Reader Format cannot be null.");
        }
        this.fileReaderFormat = fileReaderFormat;
    }

    public EncoderStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    public void setFileWriterFormat(EncoderStrategy<E,D> fileWriterFormat) {
        if(fileWriterFormat == null){
            throw new IllegalArgumentException("File Writer Format cannot be null.");
        }
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
        lab4.Startup.main(args);//requirements, lol
        
        //but seriously, for examples, see:
        //lab4.Startup
        //lab4.ContactConversionSample
        //lab4.NullFormattersTesting
    }
    
}

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
 * FileReaderFormat and FileWriterFormat can be null if reading/writing is not
 * needed. isReadable() and isWritable() return whether
 * 
 * "I love type erasure!"
 *      -No one ever
 * 
 * @author Joe Rankin
 */
public class FileService<E, D>{//<EncodedFormat, DecodedFormat>//viable?
    FileReaderStrategy<E> fileReader;//TextFileReader/BinaryFileReader
    FileWriterStrategy<E> fileWriter;//TextFileWriter/BinaryFileWriter
    DecoderStrategy<E,D> fileReaderFormat;
    EncoderStrategy<E,D> fileWriterFormat;
    
    public FileService(FileHandlerStrategy<E> fileHandler, FormatStrategy<E,D> format){
        setFileReader(fileHandler);
        setFileWriter(fileHandler);
        setFileReaderFormat(format);
        setFileWriterFormat(format);
    }

    public FileService(FileReaderStrategy<E> fileReader, 
            FileWriterStrategy<E> fileWriter, 
            DecoderStrategy<E,D> fileReaderFormat,
            EncoderStrategy<E,D> fileWriterFormat) 
    {
        setFileReader(fileReader);
        setFileWriter(fileWriter);
        setFileReaderFormat(fileReaderFormat);
        setFileWriterFormat(fileWriterFormat);
    }
    
    /**
     * Writes to a file given a List containing objects to encode or file lines
     * @param objects list of objects to encode/write to file
     * @return success boolean
     * @throws IOException if there's a problem writing to file
     * @throws UnsupportedOperationException when fileWriter is null
     */
    public final boolean writeFile(List<D> objects) throws IOException, UnsupportedOperationException{
        if(isWriteable() && fileWriterFormat != null){
            List<E> encodedLines = fileWriterFormat.encode(objects);
            return fileWriter.writeFile(encodedLines);
        } else{
            //just return false?
            throw new UnsupportedOperationException("Cannot write to / format with null");
        }
    }
    
    /**
     * Reads from a file into a List containing decoded objects.
     * @return List of file lines or list of decoded objects depending on if the
     * fileReaderFormat is null or not.
     * @throws IOException when file reading errors
     * @throws UnsupportedOperationException when fileReader is null
     */
    public final List<D> readFile() throws IOException, UnsupportedOperationException{
        if(isReadable() && fileReaderFormat != null){
            List<E> fileLines = fileReader.readFile();
            return fileReaderFormat.decode(fileLines);
        } else{
            throw new UnsupportedOperationException("Can't read from / format with null");
        }
    }
    
    
    public final List<E> encode(List<D> data) {
        if(fileWriterFormat == null){
            throw new UnsupportedOperationException("Cannot encode data with null encoder.");
        }
        return fileWriterFormat.encode(data);
    }

    public final List<D> decode(List<E> data) {
        if(fileReaderFormat == null){
            throw new UnsupportedOperationException("Cannot decode data with null decoder.");
        }
        return fileReaderFormat.decode(data);
    }
    

    public final FileReaderStrategy getFileReader() {
        return fileReader;
    }

    public final void setFileReader(FileReaderStrategy<E> fileReader) {
//        if(fileReader == null){
//            throw new IllegalArgumentException("File Reader cannot be null");
//        }
        this.fileReader = fileReader;
    }

    public final FileWriterStrategy getFileWriter() {
        return fileWriter;
    }

    public final void setFileWriter(FileWriterStrategy<E> fileWriter) {
//        if(fileWriter == null){
//            throw new IllegalArgumentException("File Writer cannot be null");
//        }
        this.fileWriter = fileWriter;
    }

    public final DecoderStrategy getFileReaderFormat() {
        return fileReaderFormat;
    }

    public final void setFileReaderFormat(DecoderStrategy<E,D> fileReaderFormat) {
        if(fileReaderFormat == null){
            throw new IllegalArgumentException("File Reader Format cannot be null.");
        }
        this.fileReaderFormat = fileReaderFormat;
    }

    public final EncoderStrategy getFileWriterFormat() {
        return fileWriterFormat;
    }

    public final void setFileWriterFormat(EncoderStrategy<E,D> fileWriterFormat) {
        if(fileWriterFormat == null){
            throw new IllegalArgumentException("File Writer Format cannot be null.");
        }
        this.fileWriterFormat = fileWriterFormat;
    }

    public final void setAppend(boolean append) {
        fileWriter.setAppend(append);
    }

    public final boolean doesAppend() {
        return fileWriter.doesAppend();
    }
    
    public final boolean isWriteable(){
        return fileWriter != null;
    }
    
    public final boolean isReadable(){
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

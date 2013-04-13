package lab4.FileService.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lab4.FileService.*;

/**
 * @author Joe
 */
public class TextFileReader implements FileReaderStrategy {
    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public List readFile() throws IOException {
        List lines = new ArrayList();

        BufferedReader in = new BufferedReader(
                new FileReader(filePath));
        String line = in.readLine();
        while (line != null) {
            lines.add(line);
            line = in.readLine();
        }
        
        
        in.close();

        return lines;
    }
    
    //helper method
    public static List readFile(String filePath) throws IOException {
        return new TextFileReader(filePath).readFile();
    }
}

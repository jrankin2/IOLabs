package lab4.FileService.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import lab4.FileService.FileType;
import lab4.FileService.FileWriterStrategy;

/**
 * @author Joe
 */
public class TextFileWriter implements FileWriterStrategy {

    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;
    private boolean append;

    public TextFileWriter(String filePath, boolean append) {
        this.filePath = filePath;
        this.append = append;
    }

    @Override
    public boolean writeFile(List objects) throws IOException {
        //needs validation...
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(filePath, append)));

        StringBuilder sbuf = new StringBuilder();
        for (int i = 0; i < objects.size(); i++) {
            sbuf.append(objects.get(i)).append("\n");
        }
        out.println(sbuf.toString());
        out.close();

        return true;
    }
    
    //helper method
    public static boolean writeFile(String filePath, boolean append, List objects) throws IOException{
        return new TextFileWriter(filePath, append).writeFile(objects);
    }
}

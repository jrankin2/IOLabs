package lab4.FileService.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import lab4.FileService.FileHandlerStrategy;
import lab4.FileService.FileType;

/**
 *
 * @author Joe Rankin
 */
public class TextFileHandler implements FileHandlerStrategy<String>{
    private static final FileType FILE_TYPE = FileType.TEXT_FILE;
    private String filePath;
    private boolean append;
    
    public TextFileHandler(String filePath){
        this.filePath = filePath;
        this.append = true;//on the safe side.
    }

    public TextFileHandler(String filePath, boolean appends) {
        this.filePath = filePath;
    }
    
    @Override
    public List<String> readFile() throws IOException {
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
    public static List<String> readFile(String filePath) throws IOException {
        return new TextFileReader(filePath).readFile();
    }
    
    @Override
    public boolean writeFile(List<String> objects) throws IOException {
        //needs validation...
        //System.out.println("objects = " + objects);//debug
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(filePath, append)));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objects.size(); i++) {
            sb.append(objects.get(i));
            if(i != objects.size()-1) sb.append("\n");//if not last line, add a new one
        }
        out.println(sb.toString());
        out.close();

        return true;
    }
    
    //helper method
    public static boolean writeFile(String filePath, boolean append, List objects) throws IOException{
        return new TextFileWriter(filePath, append).writeFile(objects);
    }

    @Override
    public void setAppend(boolean append) {
        this.append = append;
    }

    @Override
    public boolean doesAppend() {
        return append;
    }
}

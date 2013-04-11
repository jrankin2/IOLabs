/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jrankin2
 */
public class Startup {
    public static void main(String[] args) {
        Startup.outputContact(2);
    }
    
    public static void outputContact(int contactNumber){
        File data = new File("/contacts.txt");

        BufferedReader in = null;
        try {
            int i = 0;
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            String[] lineFields;
            while (line != null) {
                if(i == contactNumber){
                    lineFields = line.split("\\|");
                    System.out.printf("name: %s,  street: %s, city: %s, email: %s, phone: %s\n",
                        lineFields[1]+" "+lineFields[0],//name
                        lineFields[2],//street
                        lineFields[3] + ", " + lineFields[4] + " " + lineFields[5],//city
                        lineFields[6],//email
                        lineFields[7]//phone
                        );
                    
                }
                
                //Smith|Bob|1234 Street St.|Milwaukee|WI|53186|bob@gmail.com|222-333-4444
                i++;
                line = in.readLine();  // strips out any carriage return chars
            }

        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
}

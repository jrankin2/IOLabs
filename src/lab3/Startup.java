/*
 * To change this template, choose Tools "," Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author jrankin2
 */
public class Startup {
    private static Object contact;
    public static void main(String[] args) throws IOException {

        Contact a = new Contact("Smith","Bob","1234 Street St.","Milwaukee","WI","53186","bob@gmail.com","222-333-4444");
        writeContact(a);
        readOutputContact(0);
    }
    
    public static void writeContact(Contact contact) throws IOException{
        boolean append = true;
        File data = new File("/contactsSerialized.txt");
        
        ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream( new FileOutputStream(data, append)) );

        out.writeObject(contact);
        out.close();  // be sure you close your streams when done!!

        System.out.println("Wrote file to: " + data.getAbsolutePath());
        
    }
    
    public static void readOutputContact(int contactNumber){
        File data = new File("/contactsSerialized.txt");

        ObjectInputStream in = null;
        try {
            int i = 0;
            //InputStream Object = null;
            //in = new BufferedReader(new FileReader(data));
            in = new ObjectInputStream(
				new FileInputStream("/contactsSerialized.txt"));
            Contact contact = (Contact)in.readObject();
            System.out.println(contact.getCity());
            Contact contact2 = (Contact)in.readObject();
            System.out.println(contact2.getCity());
            
            
            /*
            while (contact != null) {
                if(i == contactNumber){
                    
                }
                //Smith","Bob","1234 Street St.","Milwaukee","WI","53186","bob@gmail.com","222-333-4444
                i++;
                contact = in.readObject();  //
            }
            * */

        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IO Ex:"+ioe.getMessage());
        } catch (ClassNotFoundException cnfe){
            System.out.println("cnfe = " + cnfe.getMessage());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                
            }
        }
    }

}

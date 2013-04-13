/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lab4.FileService.*;
import lab4.FileService.impl.*;

/**
 *
 * @author bitstudent
 */
public class ContactConversionSample {
    public static void main(String[] args) {
        FileReaderStrategy tfr = new TextFileReader("src/contactsTest.txt");
        FileWriterStrategy tfw = new TextFileWriter("src/contactsTest.txt", false);
        FileFormatStrategy cc = new ContactsConverter();
        List<Contact> contacts = new ArrayList<Contact>();
        List<Contact> fileContacts = null;
        //create the contacts...
        Contact a = new Contact("Smith","Bob","1234 Street St.","Milwaukee","WI","53186","bob@gmail.com","222-333-4444");
        Contact b = new Contact("Jones", "Sally", "1422 Go St.", "Waukesha", "WI", "53188", "sally@gmail.com", "333-444-5555");
        Contact c = new Contact("Smith", "Dan", "ABC Lane", "Waukesha", "WI", "53189", "dan@gmail.com", "444-555-6666");
        //add them to the list...
        contacts.add(a);
        contacts.add(b);
        contacts.add(c);
        
        FileService fs = new FileService(tfr, tfw, cc, cc);
        try{
            if(fs.writeFile(contacts)){//if writing was successful
                fileContacts = fs.readFile();
                System.out.println("All contacts read from file:");
                for (Contact contact : fileContacts) {
                    System.out.println(contact);
                }
                
                System.out.println("\n\nSecond contact:");
                System.out.println(fileContacts.get(1));
                
                System.out.println("\n\nSecond contact's city:");
                System.out.println(fileContacts.get(1).getCity());
            }
            
        } catch(IOException ioe){
            System.out.println("IOException occurred while reading/writing file:" + ioe.getMessage());
        }
        
        
        
    }
}

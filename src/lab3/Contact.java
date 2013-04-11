/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.Serializable;

/**
 *
 * @author jrankin2
 *  first name, last name, street address, 
city, state, zip, email, phone fields
 */
public class Contact implements Serializable {
    private String lastName;
    private String firstName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phone;

    public Contact(String lastName, String firstName, String streetAddress, String city, String state, String zipCode, String email, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    
}

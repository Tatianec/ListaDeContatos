package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactDatabase implements ContactDao{

    private List<Contact> contacts = new ArrayList<>();

    private static ContactDatabase instance = null;

    public static ContactDatabase getInstance(){
        if(instance == null){
            instance = new ContactDatabase();
        }
        return instance;
    }
    public List<Contact> getAllContacts(){

        contacts.add(new Contact("Policia",  "Local", "190"));
        contacts.add(new Contact("Bombeiros",  "Local", "193"));

        return contacts;
    }

    public List<Contact> addContact(Contact contact){
        if(!contacts.contains(contact))
            contacts.add(contact);
        return contacts;
    }

    @Override
    public Contact findById(int id) {
        return null;
    }

    public boolean validateContact(int id) {

        return false;
    }
}

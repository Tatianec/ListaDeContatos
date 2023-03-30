package model;

import java.util.ArrayList;

public class User {
    int id = 0;
    String name;
    String password;

    ArrayList<Contact> contacts = new ArrayList<>();

    public User(String name, String password) {
        id += 1;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    private ArrayList<Contact> addContact(Contact contact){
        contacts.add(contact);

        return contacts;
    }

}

package com.example.app7_listacontatos.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    int id;
    String name;
    String password;
    String confPassword;
    List<Contact> contacts;

    int contador = 0;
    public User(String name, String password, String confPassword, List<Contact> contacts) {
        id = contador++;
        this.name = name;
        this.password = password;
        this.confPassword = confPassword;
        this.contacts = contacts;
    }

    public User() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confPassword='" + confPassword + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}

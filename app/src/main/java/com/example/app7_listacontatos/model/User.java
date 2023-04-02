package com.example.app7_listacontatos.model;

import com.example.app7_listacontatos.dao.UserDao;
import com.example.app7_listacontatos.dao.UserDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User{
    int id;
    String name;
    String password;
    String confPassword;
    List<Contact> contacts = new ArrayList<>();

    int contador = 0;
    public User(String name, String password, String confPassword) {
        id = contador++;
        this.name = name;
        this.password = password;
        this.confPassword = confPassword;
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


    public List<Contact> addContact(Contact contact){
        contacts.add(contact);
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

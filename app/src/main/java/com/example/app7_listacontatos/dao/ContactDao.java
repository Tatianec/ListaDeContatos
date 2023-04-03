package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.Contact;
import com.example.app7_listacontatos.model.User;

import java.util.List;

public interface ContactDao {

    List<Contact> addContact(Contact contact);

    Contact findById(int id);

    public boolean validateContact(int id);
}

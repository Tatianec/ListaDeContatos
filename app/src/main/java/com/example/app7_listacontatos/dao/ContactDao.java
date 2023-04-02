package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.Contact;
import com.example.app7_listacontatos.model.User;

public interface ContactDao {

    void addContact(Contact contact);

    User findById(int id);
}

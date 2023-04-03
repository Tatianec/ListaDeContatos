package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User findById(int id);

    boolean validateUser(String username, String password);

}

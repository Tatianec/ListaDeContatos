package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.User;

public interface UserDao {
    void addUser(User user);
    boolean validateUser(String username, String password);

}

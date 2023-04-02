package com.example.app7_listacontatos.dao;

import com.example.app7_listacontatos.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase implements UserDao {
    private List<User> users = new ArrayList<>();;
    private static UserDatabase instance = null;

    public static UserDatabase getInstance(){
        if(instance == null){
            instance = new UserDatabase();
        }
        return instance;
    }
    public List<User> getAllUsers(){
        return users;
    }

    public List<User> addUser(User user){
        if(!users.contains(user))
            users.add(user);
        return users;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public boolean validateUser(String username, String password) {
        for(User user : getAllUsers() ){
            if (user.getName().equals(username) && user.getPassword().equals(password) ) {
                return true;
            }
        }
        return false;
    }
}

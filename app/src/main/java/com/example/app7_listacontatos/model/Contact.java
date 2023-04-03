package com.example.app7_listacontatos.model;

import java.io.Serializable;

public class Contact implements Serializable {
    String nickname;

    @Override
    public String toString() {
        return "Contact{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    String name;
    String phone;

    public Contact(String nickname, String name, String phone) {
        this.nickname = nickname;
        this.name = name;
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}

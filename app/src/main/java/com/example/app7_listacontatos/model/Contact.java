package com.example.app7_listacontatos.model;

public class Contact {
    String nickname;
    String name;
    String lastName;
    String phone;

    public Contact() {
    }

    public Contact(String nickname, String name, String lastName, String phone) {
        this.nickname = nickname;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

}

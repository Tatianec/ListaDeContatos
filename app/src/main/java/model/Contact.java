package model;

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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.Matchurkorea.Match.domain;

public class User {
    private int id;
    private String name;
    private String email;
    private String character;
    private int password;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getCharacter() {
        return character;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}

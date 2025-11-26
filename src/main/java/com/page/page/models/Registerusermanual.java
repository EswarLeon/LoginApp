package com.page.page.models;

public class Registerusermanual {
    private String email;
    private String password;
    private String confirmedpassword;

    public Registerusermanual() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedpassword() {
        return confirmedpassword;
    }

    public void setConfirmedpassword(String confirmedpassword) {
        this.confirmedpassword = confirmedpassword;
    }

    public Registerusermanual(String email, String password, String confirmedpassword) {
        this.email = email;
        this.password = password;
        this.confirmedpassword = confirmedpassword;
    }


}

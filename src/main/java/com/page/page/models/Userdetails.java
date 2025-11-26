package com.page.page.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class Userdetails {
    @Id
    @GeneratedValue
    private Integer id;
    @Email
    private String email;
    private String password;
    public Userdetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "userdetails{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Userdetails(String email, String password, String confirmpassword) {
//        this.id = id;
        this.email = email;
        this.password = password;
    }
}

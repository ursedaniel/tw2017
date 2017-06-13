package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/13/2017.
 */
@Entity
@Table(name ="USERS")
public class User {

    Integer id;
    String name;
    String email;
    String role;

    public User() {}

    public User(Integer id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

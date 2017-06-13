package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/13/2017.
 */
@Entity
@Table(name ="USERS")
public class User {

    String id;
    String name;
    String role;

    public User() {}

    public User(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}

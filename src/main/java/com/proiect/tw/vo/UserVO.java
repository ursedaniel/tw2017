package com.proiect.tw.vo;

import javax.jws.soap.SOAPBinding;

/**
 * Created by JACK on 6/13/2017.
 */
public class UserVO {

    String id;
    String name;
    String role;

    public UserVO() {}

    public UserVO(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

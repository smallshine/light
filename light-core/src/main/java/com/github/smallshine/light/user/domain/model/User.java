package com.github.smallshine.light.user.domain.model;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
public class User {
    private Integer id;
    private String name;
    private Integer phone;
    private String email;

    private int status;

    public User() {
    }

    public User(Integer id, String name, Integer phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("User {\"id\": %d, name: \"%s\", phone: \"%d\", \"email\": \"%s}\"",
                id, name, phone, email);
    }
}
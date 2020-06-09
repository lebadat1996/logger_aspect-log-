package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class CustomerForm {
    private int id;
    private String name;
    private MultipartFile avatar;

    public CustomerForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}

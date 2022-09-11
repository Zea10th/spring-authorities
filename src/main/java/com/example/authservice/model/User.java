package com.example.authservice.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class User {
    private final String userName;
    private final String userPassword;
    private List<Authorities> authoritiesList;

    @Autowired
    public User(String userName, String userPassword, List<Authorities> authoritiesList) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.authoritiesList = authoritiesList;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }
}

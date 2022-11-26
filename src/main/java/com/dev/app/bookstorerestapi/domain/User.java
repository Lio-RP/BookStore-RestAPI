package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String userName;
    private String password;

    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(Long id, String firstName,
                String lastName,
                String userName,
                String email,
                String password) {
        super(id, firstName, lastName, email);
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}

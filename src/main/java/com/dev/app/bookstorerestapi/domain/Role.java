package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Role extends BaseEntity {

    private String role;

    private List<User> users = new ArrayList<>();

    private List<Privilege> privileges = new ArrayList<>();

    public Role() {
    }

    public Role(Long id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", users=" + users +
                ", privileges=" + privileges +
                '}';
    }
}

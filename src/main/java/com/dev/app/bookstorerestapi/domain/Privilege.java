package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Privilege extends BaseEntity {

    private String privilege;

    private List<Role> roles = new ArrayList<>();

    public Privilege() {
    }

    public Privilege(Long id, String privilege) {
        super(id);
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "privilege='" + privilege + '\'' +
                ", roles=" + roles +
                '}';
    }
}

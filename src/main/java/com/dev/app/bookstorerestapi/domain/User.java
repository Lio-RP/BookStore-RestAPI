package com.dev.app.bookstorerestapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends Person {

    private String userName;
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles = new ArrayList<>();
}

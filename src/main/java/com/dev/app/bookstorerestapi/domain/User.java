package com.dev.app.bookstorerestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Person {

    @NotBlank
    @Size(min = 2, max = 25)
    private String userName;

    @NotBlank
    @Size(min = 8)
    private String password;

    @OneToOne
    private Customer customer;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties("users")
    private List<Role> roles = new ArrayList<>();
}

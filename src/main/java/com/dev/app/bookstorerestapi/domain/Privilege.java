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
public class Privilege extends BaseEntity {

    private String privilege;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles = new ArrayList<>();
}

package com.dev.app.bookstorerestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Privilege extends BaseEntity {

    private String privilege;

    @ManyToMany(mappedBy = "privileges")
    @JsonIgnoreProperties("privileges")
    private List<Role> roles = new ArrayList<>();
}

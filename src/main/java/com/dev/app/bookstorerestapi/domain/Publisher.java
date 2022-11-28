package com.dev.app.bookstorerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Publisher extends BaseEntity {


    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();
}

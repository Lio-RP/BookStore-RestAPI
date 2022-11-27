package com.dev.app.bookstorerestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {

    private String bookName;
    private BigInteger isbn;
    private String edition;

    @ManyToOne
    @JsonIgnoreProperties("books")
    private Category category;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Author> authors = new ArrayList<>();
}

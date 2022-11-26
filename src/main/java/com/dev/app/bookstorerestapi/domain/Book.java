package com.dev.app.bookstorerestapi.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Book extends BaseEntity {

    private String bookName;
    private BigInteger isbn;
    private String edition;

    private Category category;

    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(Long id, String bookName, BigInteger isbn, String edition, List<Author> authors) {
        super(id);
        this.bookName = bookName;
        this.isbn = isbn;
        this.edition = edition;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public void setIsbn(BigInteger isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", isbn=" + isbn +
                ", edition='" + edition + '\'' +
                ", authors=" + authors +
                '}';
    }
}

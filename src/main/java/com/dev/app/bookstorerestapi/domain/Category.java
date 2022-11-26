package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseEntity {

    private String catName;

    private List<Book> books = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String catName, List<Book> books) {
        super(id);
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catName='" + catName + '\'' +
                ", books=" + books +
                '}';
    }
}

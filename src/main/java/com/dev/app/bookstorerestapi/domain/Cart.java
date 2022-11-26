package com.dev.app.bookstorerestapi.domain;

public class Cart extends BaseEntity {

    private int quantity;
    private float subtotalPrice;
    private Book book;

    public Cart() {
    }

    public Cart(Long id, int quantity, float subtotalPrice, Book book) {
        super(id);
        this.quantity = quantity;
        this.subtotalPrice = subtotalPrice;
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(float subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "quantity=" + quantity +
                ", subtotalPrice=" + subtotalPrice +
                ", book=" + book +
                '}';
    }
}

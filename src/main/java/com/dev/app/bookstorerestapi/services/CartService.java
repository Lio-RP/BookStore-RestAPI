package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Cart;
import com.dev.app.bookstorerestapi.domain.User;

import java.util.List;

public interface CartService {

    List<Cart> getAllCartsByUser(User user);

    Cart addToCart(Long bookId, User user);

    void updateCartItem(Long cartId, User user);

    void deleteOneItem(Long cartId, User user);

    void deleteCartItems(Long cartId, User user);

    void clearCart(User user);

    float calTotalCartsPrice(List<Cart> carts);

    int calTotalCartsQuantity(List<Cart> carts);
}

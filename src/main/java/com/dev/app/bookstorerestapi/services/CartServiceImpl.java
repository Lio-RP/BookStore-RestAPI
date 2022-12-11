package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Book;
import com.dev.app.bookstorerestapi.domain.Cart;
import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.repositories.BookRepository;
import com.dev.app.bookstorerestapi.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    public CartServiceImpl(CartRepository cartRepository,
                           BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Cart> getAllCartsByUser(User user) {
        return cartRepository.findCartsByUser(user);
    }

    @Override
    public Cart addToCart(Long bookId, User user) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(!bookOptional.isPresent()){
            throw new RuntimeException("Book with the id " + bookId + " not found!");
        }

        Book book = bookOptional.get();

        List<Cart> carts = getAllCartsByUser(user);

        Optional<Cart> cartOptional = carts
                .stream()
                .filter(cart -> cart.getBook().getId().equals(bookId))
                .findFirst();

        if(!cartOptional.isPresent()){
            Cart newCartItem = new Cart();

            newCartItem.setBook(book);
            newCartItem.setUser(user);
            newCartItem.setQuantity(1);
            newCartItem.setSubtotalPrice(book.getPrice());

            return cartRepository.save(newCartItem);
        }
        Cart cart = cartOptional.get();
        updateCartItem(cart.getId(), user);

        return cart;
    }

    @Override
    public void updateCartItem(Long cartId, User user) {
        List<Cart> carts = getAllCartsByUser(user);

        Optional<Cart> cartOptional = carts.stream().filter(cart -> cart.getId().equals(cartId)).findFirst();

        if(cartOptional.isPresent()){
            Cart cart = cartOptional.get();

            cart.setQuantity(cart.getQuantity() + 1);
            cart.setSubtotalPrice(cart.getSubtotalPrice() * cart.getQuantity());

            cartRepository.save(cart);
        }
    }

    @Override
    public void deleteOneItem(Long cartId, User user) {
        List<Cart> carts = getAllCartsByUser(user);

        Optional<Cart> cartOptional = carts.stream().filter(cart -> cart.getId().equals(cartId)).findFirst();

        if(cartOptional.isPresent()){
            Cart cart = cartOptional.get();

            if(cart.getQuantity() > 1){

                cart.setQuantity(cart.getQuantity() - 1);
                cart.setSubtotalPrice(cart.getSubtotalPrice() * cart.getQuantity());

                cartRepository.save(cart);

            }else {
                cartRepository.delete(cart);
            }
        }
    }

    @Override
    public void deleteCartItems(Long cartId, User user) {
        List<Cart> carts = getAllCartsByUser(user);

        Optional<Cart> cartOptional = carts.stream().filter(cart -> cart.getId().equals(cartId)).findFirst();

        if (cartOptional.isPresent()){
            Cart cart = cartOptional.get();
            cartRepository.delete(cart);
        }else {
            throw new RuntimeException("Cart with id " + cartId + " not found");
        }
    }

    @Override
    public void clearCart(User user) {
        List<Cart> carts = getAllCartsByUser(user);
        cartRepository.deleteAll(carts);
    }

    @Override
    public float calTotalCartsPrice(List<Cart> carts) {
        float totalCartsPricae = 0;
        for(Cart cart : carts){
            totalCartsPricae += cart.getSubtotalPrice();
        }
        return totalCartsPricae;
    }

    @Override
    public int calTotalCartsQuantity(List<Cart> carts) {
        int totalCartsQuantity = 0;
        for(Cart cart : carts){
            totalCartsQuantity += cart.getQuantity();
        }
        return totalCartsQuantity;
    }
}

package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.auth.UserPrincipal;
import com.dev.app.bookstorerestapi.domain.Cart;
import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.services.CartService;
import com.dev.app.bookstorerestapi.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cart Controller")
@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService,
                          UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @Operation(summary = "Get All Carts by currently logged user")
    @GetMapping("/carts")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> displayAllCarts(@AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        List<Cart> carts = cartService.getAllCartsByUser(user);
        return  carts;
    }

    @Operation(summary = "Add Cart Item")
    @GetMapping("/products/{id}/add")
    @ResponseStatus(HttpStatus.OK)
    public Cart addToCart(@PathVariable Long id,
                          @AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        Cart addedCart = cartService.addToCart(id, user);
        return addedCart;
    }

    @Operation(summary = "Delete Cart Items")
    @DeleteMapping("/carts/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCartItems(@PathVariable Long id,
                               @AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        cartService.deleteCartItems(id, user);
    }

    @Operation(summary = "Update Cart Items By Adding item")
    @GetMapping("/carts/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateCartItem(@PathVariable Long id,
                                   @AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        cartService.updateCartItem(id, user);
    }

    @Operation(summary = "Update Cart item by deleting item")
    @GetMapping("/carts/{id}/delete-One-Item")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneItem(@PathVariable Long id,
                              @AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        cartService.deleteOneItem(id, user);
    }
}

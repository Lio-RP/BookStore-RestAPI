package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.auth.UserPrincipal;
import com.dev.app.bookstorerestapi.domain.User;

public interface UserService {

    User findByEmail(String email);

    User findByUserName(String userName);

    User register(User user);

    User getCurrentlyLoggedUser(UserPrincipal userPrincipal);

    boolean emailExists(String email);
}

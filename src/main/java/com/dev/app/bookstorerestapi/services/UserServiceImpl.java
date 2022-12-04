package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.auth.UserPrincipal;
import com.dev.app.bookstorerestapi.domain.Role;
import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.repositories.RoleRepository;
import com.dev.app.bookstorerestapi.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User register(User user) {
        User userName = userRepository.findByUserName(user.getUserName());
        if(emailExists(user.getEmail()) || userName != null){
            throw new RuntimeException("the email or username already exist!");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        Role customer_role = roleRepository.findByRole("CUSTOMER");
        user.getRoles().add(customer_role);
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    @Override
    public User getCurrentlyLoggedUser(UserPrincipal userPrincipal) {
        if(userPrincipal == null) return null;

        return userPrincipal.getUser();
    }

    @Override
    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }
}

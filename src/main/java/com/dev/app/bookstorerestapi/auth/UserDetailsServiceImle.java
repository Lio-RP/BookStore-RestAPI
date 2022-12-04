package com.dev.app.bookstorerestapi.auth;

import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImle implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if( user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setUser(user);
        return userPrincipal;
    }
}

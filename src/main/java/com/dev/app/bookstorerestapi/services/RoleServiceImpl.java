package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Role;
import com.dev.app.bookstorerestapi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByRole(String role) {
        return roleRepository.findByRole(role);
    }
}

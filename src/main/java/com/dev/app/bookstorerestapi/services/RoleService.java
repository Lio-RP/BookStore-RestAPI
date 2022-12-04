package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Role;

public interface RoleService {

    Role getByRole(String role);
}

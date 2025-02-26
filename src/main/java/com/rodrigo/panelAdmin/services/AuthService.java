package com.rodrigo.panelAdmin.services;

import com.rodrigo.panelAdmin.entities.User;

import java.util.List;

public interface AuthService {
    User login(String email, String password);
}

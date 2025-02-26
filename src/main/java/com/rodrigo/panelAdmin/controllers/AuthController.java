package com.rodrigo.panelAdmin.controllers;

import com.rodrigo.panelAdmin.dto.RequestLogin;
import com.rodrigo.panelAdmin.entities.User;
import com.rodrigo.panelAdmin.repository.UserRepository;
import com.rodrigo.panelAdmin.services.AuthService;
import com.rodrigo.panelAdmin.services.AuthServiceImp;
import com.rodrigo.panelAdmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthServiceImp authService;
    @GetMapping("/auth/login")
    public User login(@RequestBody RequestLogin request){
        String email = request.getEmail();
        String password = request.getPassword();
        User user = authService.login(email, password);
        return user;
    }
}

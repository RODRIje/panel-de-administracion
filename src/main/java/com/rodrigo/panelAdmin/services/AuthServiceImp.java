package com.rodrigo.panelAdmin.services;

import com.google.common.hash.Hashing;
import com.rodrigo.panelAdmin.entities.User;
import com.rodrigo.panelAdmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AuthServiceImp implements AuthService{
    private static final String SECRET_KEY = "gj43jng9";

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        String hashPassword = Hashing.sha256()
                .hashString(password +  SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        List<User> result = userRepository.findByEmailAndPassword(email, hashPassword);

        if (result.isEmpty()){
            return null;
        }else {
            return result.get(0);
        }

    }
}

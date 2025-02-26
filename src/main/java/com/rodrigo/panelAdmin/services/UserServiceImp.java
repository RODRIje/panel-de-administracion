package com.rodrigo.panelAdmin.services;

import com.google.common.hash.Hashing;
import com.rodrigo.panelAdmin.entities.User;
import com.rodrigo.panelAdmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private static final String SECRET_KEY = "gj43jng9";
    @Autowired
    private UserRepository userRepository;

    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();
        for (User user:users) {
            list.add(user);
        }
        return list;
    }

    public void removeUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void addUser(User user) {
        String hashPassword = Hashing.sha256()
                .hashString(user.getPassword() + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        user.setPassword(hashPassword);
        userRepository.save(user);
    }

    public void updateUser(Integer id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }


    public List<User> searchUser(String email, String address) {
        return userRepository.findByEmailOrAddress(email, address);
    }
}

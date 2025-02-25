package com.rodrigo.panelAdmin.controllers;

import com.rodrigo.panelAdmin.entities.User;
import com.rodrigo.panelAdmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}") // Traer un cliente especifico
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/user") // Traer todos los clientes
    public List<User> getAllUsers() {


        return userService.getAllUsers();
    }

    @DeleteMapping("/user/{id}") // Eliminar un cliente
    public void removeUser(@PathVariable Integer id) {
        userService.removeUser(id);
    }

    @PostMapping("/user") // Agregar cliente
    public void register(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/user/{id}") // Modificar cliente
    public void updateUser(@PathVariable Integer id,
                           @RequestBody User updateUser) {
        userService.updateUser(id, updateUser);
    }


    @GetMapping("/user/search") // Busqueda
    public List<User> searchUser(@RequestParam(name = "email", required = false) String email,
                                 @RequestParam(name = "address", required = false) String address) {
        return userService.searchUser(email, address);
    }
}

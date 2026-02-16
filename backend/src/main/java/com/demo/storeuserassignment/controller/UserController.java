package com.demo.storeuserassignment.controller;

import com.demo.storeuserassignment.entity.Store;
import com.demo.storeuserassignment.entity.User;
import com.demo.storeuserassignment.repository.StoreRepository;
import com.demo.storeuserassignment.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public UserController(UserRepository userRepository,
                          StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.storeRepository = storeRepository;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        // Find store by pincode
        Store store = storeRepository.findByPincode(user.getPincode());

        // Assign store if found
        if (store != null) {
            user.setStore(store);
        }

        return userRepository.save(user);
    }
}

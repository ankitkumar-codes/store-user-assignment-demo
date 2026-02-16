package com.demo.storeuserassignment.controller;

import com.demo.storeuserassignment.entity.Store;
import com.demo.storeuserassignment.repository.StoreRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@CrossOrigin
public class StoreController {

    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeRepository.save(store);
    }
}

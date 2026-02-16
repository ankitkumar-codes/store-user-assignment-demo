package com.demo.storeuserassignment.repository;

import com.demo.storeuserassignment.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByPincode(String pincode);
}

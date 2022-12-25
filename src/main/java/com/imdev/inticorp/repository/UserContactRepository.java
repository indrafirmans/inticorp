package com.imdev.inticorp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdev.inticorp.entity.UserContactEntity;

public interface UserContactRepository extends JpaRepository<UserContactEntity, String>{
 
    public UserContactEntity findByAddress(String address);
}

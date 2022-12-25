package com.imdev.inticorp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdev.inticorp.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    public UserEntity findByName(String name);

    public UserEntity findByAge(int name);
}

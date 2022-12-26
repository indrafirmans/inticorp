package com.imdev.inticorp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdev.inticorp.entity.UserContactEntity;

public interface UserContactRepository extends JpaRepository<UserContactEntity, String>{
 
    public List<UserContactEntity> findByIdUser(String idUSer);
}

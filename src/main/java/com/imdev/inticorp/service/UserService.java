package com.imdev.inticorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdev.inticorp.dto.request.UserRequest;
import com.imdev.inticorp.entity.UserContactEntity;
import com.imdev.inticorp.entity.UserEntity;
import com.imdev.inticorp.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private UserContactRepository userContactRepository;

    public void createUser(UserRequest payload) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(payload.getName());
        userEntity.setAge(payload.getAge());
        userRepository.save(userEntity);
    }

    public UserEntity getUser() {
        UserEntity response = new UserEntity();
        return response;
    }

    public UserContactEntity getUserContact() {
        UserContactEntity response = new UserContactEntity();
        return response;
    }
}

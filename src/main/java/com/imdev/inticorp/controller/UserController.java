package com.imdev.inticorp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imdev.inticorp.contant.contant;
import com.imdev.inticorp.dto.request.UserRequest;
import com.imdev.inticorp.dto.response.DefaultResponse;
import com.imdev.inticorp.entity.UserContactEntity;
import com.imdev.inticorp.entity.UserEntity;
import com.imdev.inticorp.service.UserService;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping(path = contant.URL_USER)
    public ResponseEntity<DefaultResponse<String>> createUser(@RequestBody UserRequest payload) {
        DefaultResponse<String> result = new DefaultResponse<>();
        userService.createUser(payload);
        result.setStatus(HttpStatus.CREATED.value());
        result.setData(HttpStatus.CREATED.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(path = contant.URL_USER)
    public ResponseEntity<DefaultResponse<UserEntity>> getUser() {
        DefaultResponse<UserEntity> result = new DefaultResponse<>();
        UserEntity userEntity = userService.getUser();
        result.setStatus(HttpStatus.OK.value());
        result.setData(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(path = contant.URL_USER_CONTACT)
    public ResponseEntity<DefaultResponse<UserEntity>> createUserContact() {
        DefaultResponse<UserEntity> result = new DefaultResponse<>();
        UserEntity userEntity = userService.getUser();
        result.setStatus(HttpStatus.OK.value());
        result.setData(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(path = contant.URL_USER_CONTACT)
    public ResponseEntity<DefaultResponse<UserContactEntity>> getUserContact() {
        DefaultResponse<UserContactEntity> result = new DefaultResponse<>();
        UserContactEntity userContactEntity = userService.getUserContact();
        result.setStatus(HttpStatus.OK.value());
        result.setData(userContactEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
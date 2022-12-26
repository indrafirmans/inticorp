package com.imdev.inticorp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imdev.inticorp.contant.contant;
import com.imdev.inticorp.dto.request.UserContactRequest;
import com.imdev.inticorp.dto.request.UserRequest;
import com.imdev.inticorp.dto.response.DefaultResponse;
import com.imdev.inticorp.dto.response.UserContactResponse;
import com.imdev.inticorp.dto.response.UserResponse;
import com.imdev.inticorp.dto.response.UsersResponse;
import com.imdev.inticorp.exception.DuplicateDataException;
import com.imdev.inticorp.exception.NotDataFoundException;
import com.imdev.inticorp.service.UserService;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = contant.URL_USER)
    public ResponseEntity<DefaultResponse<UserResponse>> createUser(@RequestBody UserRequest payload)
            throws Exception, DuplicateDataException {

        DefaultResponse<UserResponse> result = new DefaultResponse<>();

        UserResponse data = userService.createUser(payload);
        result.setStatus(HttpStatus.CREATED.value());
        result.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping(path = contant.URL_USER_CONTACT)
    public ResponseEntity<DefaultResponse<UserContactResponse>> createUserContact(@RequestBody UserContactRequest payload)
            throws Exception {

        DefaultResponse<UserContactResponse> result = new DefaultResponse<>();

        UserContactResponse data = userService.createUserContact(payload);
        result.setStatus(HttpStatus.CREATED.value());
        result.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(path = contant.URL_USERS)
    public ResponseEntity<DefaultResponse<List<UsersResponse>>> getUser() throws Exception, NotDataFoundException {

        DefaultResponse<List<UsersResponse>> result = new DefaultResponse<>();

        List<UsersResponse> userEntity = userService.getUser();
        result.setStatus(HttpStatus.OK.value());
        result.setData(userEntity);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
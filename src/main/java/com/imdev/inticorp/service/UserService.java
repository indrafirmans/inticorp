package com.imdev.inticorp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdev.inticorp.dto.request.UserContactRequest;
import com.imdev.inticorp.dto.request.UserRequest;
import com.imdev.inticorp.dto.response.UserContactResponse;
import com.imdev.inticorp.dto.response.UserResponse;
import com.imdev.inticorp.dto.response.UsersResponse;
import com.imdev.inticorp.entity.UserContactEntity;
import com.imdev.inticorp.entity.UserEntity;
import com.imdev.inticorp.exception.DuplicateDataException;
import com.imdev.inticorp.exception.NotDataFoundException;
import com.imdev.inticorp.repository.UserContactRepository;
import com.imdev.inticorp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserContactRepository userContactRepository;

    public UserResponse createUser(UserRequest payload) throws Exception, DuplicateDataException {
        ModelMapper mapper = new ModelMapper();
        UserEntity data = new UserEntity();

        UserEntity checkExsist = userRepository.findByName(payload.getName());
        if (!Objects.isNull(checkExsist)) {
            throw new DuplicateDataException();
        }

        data.setName(payload.getName());
        data.setAge(payload.getAge());
        UserEntity userEntityLatest = userRepository.save(data);

        return mapper.map(userEntityLatest, UserResponse.class);
    }

    public UserContactResponse createUserContact(UserContactRequest payload) throws Exception {
        ModelMapper mapper = new ModelMapper();
        UserContactEntity data = new UserContactEntity();
        
        data.setAddress(payload.getAddress());
        data.setIdUser(payload.getUserId());
        UserContactEntity userEntityContactLatest = userContactRepository.save(data);

        return mapper.map(userEntityContactLatest, UserContactResponse.class);
    }

    public List<UsersResponse> getUser() throws Exception, NotDataFoundException {
        List<UsersResponse> result = new ArrayList<>();
        List<UserEntity> users = userRepository.findAll();

        if (users.size() == 0) {
            throw new NotDataFoundException();
        }

        for (UserEntity data : users) {
            UsersResponse userResponse = new UsersResponse();
            List<UserContactResponse> userContactResponseList = new ArrayList<>();

            userResponse.setId(data.getIdUser());
            userResponse.setName(data.getName());
            userResponse.setAge(data.getAge());

            List<UserContactEntity> userContactEntityList = userContactRepository.findByIdUser(data.getIdUser());

            for (UserContactEntity userContactEntity : userContactEntityList) {
                UserContactResponse userContactResponse = new UserContactResponse();
                userContactResponse.setIdUserContact(userContactEntity.getIdUser());
                userContactResponse.setAddress(userContactEntity.getAddress());
                userContactResponse.setUser(userContactEntity.getIdUser());
                userContactResponseList.add(userContactResponse);
            }
            userResponse.setUserContactResponsesList(userContactResponseList);

            result.add(userResponse);
        }

        return result;
    }
}

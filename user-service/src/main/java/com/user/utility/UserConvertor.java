package com.user.utility;

import com.user.entity.UserEntity;
import com.user.model.UserRequest;
import com.user.model.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    private final PasswordEncoder passwordEncoder;

    public UserConvertor(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity requestToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setAge(userRequest.getAge());
        userEntity.setRole(userRequest.getRole());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setEmailId(userRequest.getEmailId());
        userEntity.setUserName(userRequest.getUserName());
        return userEntity;
    }

    public UserResponse entityToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(userEntity.getUserId());
        userResponse.setName(userEntity.getName());
        userResponse.setRole(userEntity.getRole());
        userResponse.setPhoneNumber(userEntity.getPhoneNumber());
        userResponse.setAge(userEntity.getAge());
        userResponse.setEmailId(userEntity.getEmailId());
        userResponse.setAccountCreatedDate(userEntity.getAccountCreatedDate());
        userResponse.setUserName(userEntity.getUserName());
        return userResponse;
    }

    public UserEntity updateEntity(UserRequest userRequest, UserEntity userEntity) {
        userEntity.setName(userRequest.getName());
        userEntity.setAge(userRequest.getAge());
        userEntity.setRole(userRequest.getRole());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setPhoneNumber(userRequest.getPhoneNumber());
        userEntity.setEmailId(userRequest.getEmailId());
        userEntity.setUserName(userRequest.getUserName());
        return userEntity;
    }
}

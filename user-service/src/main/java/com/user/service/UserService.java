package com.user.service;

import com.user.config.CustomUserDetails;
import com.user.entity.UserEntity;
import com.user.enums.Status;
import com.user.globalException.UserResponseException;
import com.user.model.UserRequest;
import com.user.model.UserResponse;
import com.user.repository.UserRepository;
import com.user.utility.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertor convertor;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserResponse createUser(UserRequest userRequest) {
        UserResponse userResponse = null;
        if (Objects.nonNull(userRequest)) {
            UserEntity userEntity = convertor.requestToEntity(userRequest);
            String password = userEntity.getPassword();
            String encryptedPwd = passwordEncoder.encode(password);
            userEntity.setPassword(encryptedPwd);
            userEntity = userRepository.save(userEntity);
            userResponse = convertor.entityToResponse(userEntity);
        }
        return userResponse;
    }

    public UserResponse findUserByUserId(Long userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserByUserId(userId);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return convertor.entityToResponse(userEntity);
        } else {
            throw new UserResponseException("Order not found for ID: " + userId);
        }
    }

    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        return userRepository.findById(userId).map(userEntity -> {
            UserEntity updatedUserEntity = convertor.updateEntity(userRequest, userEntity);
            UserEntity savedUserEntity = userRepository.save(updatedUserEntity);
            return convertor.entityToResponse(savedUserEntity);
        }).orElseThrow(() -> new UserResponseException("user with id " + userId + " details not updated "));
    }

    public Status deleteUserById(Long userId) {
        Optional<UserEntity> optionalEntity = userRepository.findById(userId);
        if (optionalEntity.isPresent()) {
            userRepository.deleteById(userId);
            return Status.SUCCESS;
        }
        return Status.FAILED;
    }

//    @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            UserEntity user = userRepository.findByUsername(username);
//            CustomUserDetails userDetails = null;
//            if (user != null) {
//                userDetails = new CustomUserDetails();
//                userDetails.setUser(user);
//            } else {
//                throw new UsernameNotFoundException("User not exist with name : " + username);
//            }
//            return userDetails;
//
//        }

    }


package com.user.model;

import com.user.enums.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {

    private Long userId;
    private String name;
    private Role role;
    private Long phoneNumber;
    private Integer age;
    private String emailId;
    private LocalDate accountCreatedDate;
    private String userName;

}

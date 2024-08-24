package com.user.model;

import com.user.enums.Role;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Role role;
    private String password;
    private Long phoneNumber;
    private Integer age;
    private String emailId;
    private String userName;

}

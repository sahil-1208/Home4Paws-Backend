package com.user.entity;

import com.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long userId;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String userName;
    private String password;
    private Long phoneNumber;
    private Integer age;
    private String emailId;

    @CreationTimestamp
    private LocalDate accountCreatedDate;


}

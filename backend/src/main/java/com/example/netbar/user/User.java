package com.example.netbar.user;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role; // ADMIN, MERCHANT, USER

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;
}


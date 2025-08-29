package com.example.netbar.member;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Member")
public class Member extends BaseEntity {
    private Long userId;       // bind to user if registered
    private String nickname;
    private String levelCode;  // level identifier
    private Integer points;    // total points
    private Boolean merchant;  // whether business side
}


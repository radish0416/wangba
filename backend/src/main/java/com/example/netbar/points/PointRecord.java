package com.example.netbar.points;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PointRecord")
public class PointRecord extends BaseEntity {
    private Long memberId;
    private Integer delta; // points change
    private Integer balance;
    @Enumerated(EnumType.STRING)
    private PointSource source; // SIGNIN, CONSUME, EXCHANGE
    private String remark;
}


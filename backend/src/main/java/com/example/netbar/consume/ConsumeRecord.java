package com.example.netbar.consume;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ConsumeRecord")
public class ConsumeRecord extends BaseEntity {
    private Long memberId;
    private Long deviceId;
    private Long orderId;
    private Long amountFen; // consumed amount
    private Long durationSeconds; // up-time seconds
}


package com.example.netbar.payment;

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
@Table(name = "PaymentRecord")
public class PaymentRecord extends BaseEntity {
    private Long orderId;
    private String tradeNo;      // cash register trade no
    private Long amountFen;
    @Enumerated(EnumType.STRING)
    private PaymentChannel channel;
    private String status;       // SUCCESS/FAILED/PENDING
}


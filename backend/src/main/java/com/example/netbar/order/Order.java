package com.example.netbar.order;

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
@Table(name = "OrderRecord")
public class Order extends BaseEntity {
    private String orderNo;
    private Long memberId;
    private Long deviceId;     // PC device id
    private Long productId;    // if goods purchase
    private Long merchantId;   // store/merchant
    private Long amountFen;    // amount in fen

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}


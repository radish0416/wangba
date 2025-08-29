package com.example.netbar.promotion;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Promotion")
public class Promotion extends BaseEntity {
    private Long merchantId;
    @Enumerated(EnumType.STRING)
    private PromotionType type; // FULL_REDUCTION, TIME_DISCOUNT
    private String ruleJson;    // flexible rule encoded as JSON
    private Date startTime;
    private Date endTime;
    private Boolean enabled;
}


package com.example.netbar.product;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product extends BaseEntity {
    private String name;
    private String sku;
    private Long merchantId;
    private Long priceFen;
    private Boolean enabled;
}


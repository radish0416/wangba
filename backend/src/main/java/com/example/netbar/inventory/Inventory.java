package com.example.netbar.inventory;

import com.example.netbar.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Inventory")
public class Inventory extends BaseEntity {
    private Long productId;
    private Integer stock;
    private Integer lowStockThreshold;
    private Boolean autoOffShelf; // when stock below threshold
}


package com.example.netbar.device;

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
@Table(name = "Device")
public class Device extends BaseEntity {
    private Long merchantId;
    private String name;
    private String locationCode; // e.g., floor/zone/seat
    private String externalId;   // id in control system
    @Enumerated(EnumType.STRING)
    private DeviceStatus status; // ONLINE/OFFLINE/FAULT
}


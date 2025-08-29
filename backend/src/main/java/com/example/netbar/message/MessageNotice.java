package com.example.netbar.message;

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
@Table(name = "MessageNotice")
public class MessageNotice extends BaseEntity {
    private Long targetUserId;     // who to notify; null for broadcast
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private NoticeType type;       // NOTIFY, FAULT, ORDER
    private Boolean readFlag = false;
}


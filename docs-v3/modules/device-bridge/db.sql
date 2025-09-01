-- 设备桥接
CREATE TABLE `device_action_log` (
  `id` BIGINT NOT NULL,
  `seat_id` BIGINT NOT NULL,
  `action` VARCHAR(16) NOT NULL COMMENT 'open|close|extend|status',
  `request_payload` JSON NULL,
  `response_payload` JSON NULL,
  `success` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_time` (`seat_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备动作日志';
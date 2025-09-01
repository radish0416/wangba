-- 设备桥接（v3 重设计）

CREATE TABLE `device_action_log` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `seat_id` BIGINT NOT NULL,
  `action` TINYINT NOT NULL COMMENT '1开机 2关机 3续费 4查询',
  `request_payload` JSON NULL,
  `response_payload` JSON NULL,
  `success` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_time` (`seat_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备动作日志';
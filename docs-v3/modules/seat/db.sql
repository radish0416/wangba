-- 机位与会话（v3 重设计）

CREATE TABLE `seat` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `area_id` BIGINT NOT NULL,
  `device_no` VARCHAR(64) NOT NULL DEFAULT '',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '1空闲 2占用 3故障',
  PRIMARY KEY (`id`),
  KEY `idx_area` (`area_id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位';

CREATE TABLE `seat_session` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `seat_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NULL,
  `duration_sec` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '1进行中 2结束 3取消',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_status` (`seat_id`,`status`),
  KEY `idx_user_time` (`user_id`,`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位会话';
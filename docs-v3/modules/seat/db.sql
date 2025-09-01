-- 机位
CREATE TABLE `seat` (
  `id` BIGINT NOT NULL,
  `area_id` BIGINT NOT NULL,
  `device_no` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '设备编号',
  `status` VARCHAR(16) NOT NULL DEFAULT 'idle' COMMENT 'idle|occupied|fault',
  `current_order_id` BIGINT NOT NULL DEFAULT 0 COMMENT '当前占用订单',
  PRIMARY KEY (`id`),
  KEY `idx_area` (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位';
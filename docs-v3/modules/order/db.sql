-- 订单模块
CREATE TABLE `order` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_type` VARCHAR(32) NOT NULL COMMENT 'time|goods|package',
  `status` VARCHAR(32) NOT NULL COMMENT 'pending|paid|canceled|refunded|closed',
  `total_amount` DECIMAL(10,2) NOT NULL,
  `pay_amount` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `pay_channel` VARCHAR(16) NOT NULL DEFAULT '' COMMENT 'wx|ali|wallet',
  `pay_time` DATETIME NULL,
  `external_no` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '外部支付单号',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

CREATE TABLE `order_item` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL DEFAULT 0,
  `title` VARCHAR(128) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 1,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细';
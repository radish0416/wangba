-- 支付桥接
CREATE TABLE `pay_transaction` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `channel` VARCHAR(16) NOT NULL COMMENT 'wx|ali|wallet',
  `trade_no` VARCHAR(64) NOT NULL COMMENT '第三方交易号',
  `status` VARCHAR(16) NOT NULL COMMENT 'init|success|closed|refund',
  `amount` DECIMAL(12,2) NOT NULL,
  `notify_payload` JSON NULL,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`),
  UNIQUE KEY `uk_trade_no` (`trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付交易';
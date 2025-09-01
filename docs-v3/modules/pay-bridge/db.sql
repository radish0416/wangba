-- 支付桥接（v3 重设计）

CREATE TABLE `pay_transaction` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `order_id` BIGINT NOT NULL,
  `channel` TINYINT NOT NULL COMMENT '1微信 2支付宝 3钱包',
  `trade_no` VARCHAR(64) NOT NULL,
  `status` TINYINT NOT NULL COMMENT '0创建 1成功 2关闭 3退款',
  `amount` DECIMAL(12,2) NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_trade_no` (`trade_no`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付交易';

CREATE TABLE `pay_notify_log` (
  `id` BIGINT NOT NULL,
  `transaction_id` BIGINT NOT NULL,
  `payload` JSON NULL,
  `received_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_txn` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付回调日志';
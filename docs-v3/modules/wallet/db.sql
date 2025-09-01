-- 钱包模块（v3 重设计）

CREATE TABLE `wallet_account` (
  `user_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `balance` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `frozen` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包账户';

CREATE TABLE `wallet_ledger` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1充值 2消费 3退款 4提现 5冻结 6解冻',
  `amount` DECIMAL(12,2) NOT NULL,
  `balance_after` DECIMAL(12,2) NOT NULL,
  `biz_id` VARCHAR(64) NOT NULL DEFAULT '',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`create_time`),
  KEY `idx_store_type` (`store_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包流水';
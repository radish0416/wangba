-- 余额与消费记录
CREATE TABLE `consume_record` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `type` VARCHAR(32) NOT NULL COMMENT 'time|goods|package',
  `amount` DECIMAL(12,2) NOT NULL,
  `pay_channel` VARCHAR(16) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费记录';
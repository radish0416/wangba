-- 余额与消费记录（v3 重设计）
-- 建议由订单与钱包流水生成，也可落表便于快速查询

CREATE TABLE `consume_record` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `biz_type` TINYINT NOT NULL COMMENT '1上机 2商品 3套餐',
  `amount` DECIMAL(12,2) NOT NULL,
  `pay_channel` TINYINT NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`create_time`),
  KEY `idx_store_type` (`store_id`,`biz_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费记录';
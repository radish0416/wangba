-- 订单模块（v3 重设计）

CREATE TABLE `order_master` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `order_type` TINYINT NOT NULL COMMENT '1上机时长 2商品 3套餐',
  `status` TINYINT NOT NULL COMMENT '0待支付 1已支付 2已取消 3已退款 4已关闭',
  `total_amount` DECIMAL(12,2) NOT NULL,
  `discount_amount` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `pay_amount` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `pay_channel` TINYINT NOT NULL DEFAULT 0 COMMENT '0未知 1微信 2支付宝 3钱包',
  `pay_time` DATETIME NULL,
  `external_no` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '外部支付单号',
  `seat_id` BIGINT NOT NULL DEFAULT 0 COMMENT '关联机位（上机订单）',
  `source_channel` TINYINT NOT NULL DEFAULT 1 COMMENT '1后台 2小程序',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  `version` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`create_time`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单主表';

CREATE TABLE `order_item` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL DEFAULT 0,
  `title` VARCHAR(128) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 1,
  `price` DECIMAL(10,2) NOT NULL,
  `amount` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细';

CREATE TABLE `order_payment` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `pay_channel` TINYINT NOT NULL,
  `out_trade_no` VARCHAR(64) NOT NULL,
  `trade_no` VARCHAR(64) NOT NULL DEFAULT '',
  `status` TINYINT NOT NULL COMMENT '0创建 1成功 2关闭 3退款',
  `amount` DECIMAL(12,2) NOT NULL,
  `notify_payload` JSON NULL,
  `pay_time` DATETIME NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_out_trade_no` (`out_trade_no`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单支付记录';

CREATE TABLE `order_refund` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `amount` DECIMAL(12,2) NOT NULL,
  `status` TINYINT NOT NULL COMMENT '0申请 1成功 2关闭',
  `reason` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单退款';
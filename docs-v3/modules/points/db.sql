-- 积分模块（v3 重设计）

CREATE TABLE `points_account` (
  `user_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `balance` BIGINT NOT NULL DEFAULT 0,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分账户';

CREATE TABLE `points_ledger` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `delta` INT NOT NULL,
  `scene` VARCHAR(32) NOT NULL COMMENT 'earn|consume|adjust',
  `biz_id` VARCHAR(64) NOT NULL DEFAULT '',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`create_time`),
  KEY `idx_store_scene` (`store_id`,`scene`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分流水';
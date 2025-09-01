-- 套餐模块（v3 重设计）

CREATE TABLE `package_def` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1时间 2次数 3混合',
  `price` DECIMAL(10,2) NOT NULL,
  `valid_days` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐定义';

CREATE TABLE `package_benefit` (
  `id` BIGINT NOT NULL,
  `package_id` BIGINT NOT NULL,
  `benefit_key` VARCHAR(64) NOT NULL,
  `benefit_value` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_pkg` (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐权益';

CREATE TABLE `user_package` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `package_id` BIGINT NOT NULL,
  `remain_time_sec` INT NOT NULL DEFAULT 0,
  `remain_count` INT NOT NULL DEFAULT 0,
  `valid_to` DATETIME NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_id`),
  KEY `idx_pkg` (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户持有套餐';

CREATE TABLE `package_redeem` (
  `id` BIGINT NOT NULL,
  `user_package_id` BIGINT NOT NULL,
  `redeem_type` TINYINT NOT NULL COMMENT '1时间 2次数',
  `redeem_value` INT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_up` (`user_package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐核销记录';
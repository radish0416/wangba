-- 会员与等级（v3 重设计）

CREATE TABLE `member_level` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(32) NOT NULL,
  `min_points` INT NOT NULL DEFAULT 0,
  `discount_rate` DECIMAL(5,2) NOT NULL DEFAULT 100.00,
  `benefits` JSON NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  `version` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员等级';

CREATE TABLE `member_user` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `level_id` BIGINT NOT NULL,
  `valid_from` DATETIME NOT NULL,
  `valid_to` DATETIME NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  `version` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_id`),
  KEY `idx_level` (`level_id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户会员记录';
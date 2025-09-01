-- 套餐模块
CREATE TABLE `package` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `type` VARCHAR(32) NOT NULL COMMENT 'time/count/mixed',
  `price` DECIMAL(10,2) NOT NULL,
  `valid_days` INT NOT NULL DEFAULT 0 COMMENT '有效天数 0=不限',
  `status` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐定义';

CREATE TABLE `package_benefit` (
  `id` BIGINT NOT NULL,
  `package_id` BIGINT NOT NULL,
  `benefit_key` VARCHAR(64) NOT NULL COMMENT '如 extra_time, discount',
  `benefit_value` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_pkg` (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐权益';
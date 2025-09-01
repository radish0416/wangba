-- 会员与等级
CREATE TABLE `member_level` (
  `id` BIGINT NOT NULL COMMENT '主键ID',
  `name` VARCHAR(32) NOT NULL COMMENT '等级名称',
  `min_points` INT NOT NULL DEFAULT 0 COMMENT '达标积分',
  `discount_rate` DECIMAL(5,2) NOT NULL DEFAULT 100.00 COMMENT '折扣(百分比)',
  `benefits` JSON NULL COMMENT '权益列表',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态 0禁用 1启用',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员等级';

CREATE TABLE `member_user` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `level_id` BIGINT NOT NULL COMMENT '等级ID',
  `valid_from` DATETIME NOT NULL COMMENT '生效时间',
  `valid_to` DATETIME NULL COMMENT '失效时间',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_id`),
  KEY `idx_level` (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户会员记录';
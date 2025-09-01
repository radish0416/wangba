-- 积分模块
CREATE TABLE `points_account` (
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `balance` BIGINT NOT NULL DEFAULT 0 COMMENT '当前积分',
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分账户';

CREATE TABLE `points_txn` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `delta` INT NOT NULL COMMENT '增减值',
  `type` VARCHAR(32) NOT NULL COMMENT '类型 earn/consume/...',
  `biz_id` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '业务单号',
  `remark` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '备注',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='积分流水';
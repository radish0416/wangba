-- 用户模块（v3 重设计）
-- 约定：所有表包含 store_id、create_time、update_time、is_deleted、version

CREATE TABLE `user` (
  `id` BIGINT NOT NULL COMMENT '主键ID',
  `store_id` BIGINT NOT NULL DEFAULT 0 COMMENT '门店/租户ID',
  `nickname` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `mobile` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `avatar_url` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
  `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '性别 0未知 1男 2女',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态 0禁用 1启用',
  `wechat_openid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信openid',
  `wechat_unionid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信unionid',
  `level_id` BIGINT NOT NULL DEFAULT 0 COMMENT '会员等级ID（快照）',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除',
  `version` INT NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile` (`mobile`),
  KEY `idx_store_user` (`store_id`,`status`),
  KEY `idx_openid` (`wechat_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';
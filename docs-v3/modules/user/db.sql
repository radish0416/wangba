-- 用户模块（v3 重设计-小驼峰+审计与扩展）
-- 统一字段：storeId, createBy, createTime, updateBy, updateTime, ext1..ext5

CREATE TABLE `user` (
  `id` BIGINT NOT NULL COMMENT '主键ID',
  `storeId` BIGINT NOT NULL DEFAULT 0 COMMENT '门店/租户ID',
  `nickname` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `mobile` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `avatarUrl` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像URL',
  `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '性别 0未知 1男 2女',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态 0禁用 1启用',
  `wechatOpenid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信openid',
  `wechatUnionid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信unionid',
  `levelId` BIGINT NOT NULL DEFAULT 0 COMMENT '会员等级ID（快照）',
  `createBy` BIGINT NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `createTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateBy` BIGINT NOT NULL DEFAULT 0 COMMENT '修改人ID',
  `updateTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `ext1` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '扩展字段1',
  `ext2` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '扩展字段2',
  `ext3` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '扩展字段3',
  `ext4` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '扩展字段4',
  `ext5` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '扩展字段5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile` (`mobile`),
  KEY `idx_store_status` (`storeId`,`status`),
  KEY `idx_openid` (`wechatOpenid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';
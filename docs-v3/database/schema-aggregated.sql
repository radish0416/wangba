-- ==== /workspace/docs-v3/modules/auth/db.sql ====

-- 认证与权限（v3 重设计）

CREATE TABLE `sys_user` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `username` VARCHAR(64) NOT NULL,
  `password_hash` VARCHAR(128) NOT NULL,
  `display_name` VARCHAR(64) NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_store_username` (`store_id`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台账户';

CREATE TABLE `sys_role` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `data_scope` TINYINT NOT NULL DEFAULT 1 COMMENT '1全部 2本门店 3本人',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

CREATE TABLE `sys_perm` (
  `id` BIGINT NOT NULL,
  `perm_key` VARCHAR(128) NOT NULL,
  `desc` VARCHAR(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_perm_key` (`perm_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限点';

CREATE TABLE `sys_user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色';

CREATE TABLE `sys_role_perm` (
  `role_id` BIGINT NOT NULL,
  `perm_id` BIGINT NOT NULL,
  PRIMARY KEY (`role_id`,`perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-权限';
-- ==== /workspace/docs-v3/modules/balance/db.sql ====

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
-- ==== /workspace/docs-v3/modules/base-service/db.sql ====

-- 基础服务（v3 重设计）

CREATE TABLE `file_object` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `bucket` VARCHAR(64) NOT NULL,
  `object_key` VARCHAR(255) NOT NULL,
  `content_type` VARCHAR(64) NOT NULL,
  `size` BIGINT NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_bucket_key` (`bucket`,`object_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件对象';

CREATE TABLE `dict_type` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `code` VARCHAR(64) NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_store_code` (`store_id`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典类型';

CREATE TABLE `dict_item` (
  `id` BIGINT NOT NULL,
  `type_id` BIGINT NOT NULL,
  `label` VARCHAR(64) NOT NULL,
  `value` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典项';

CREATE TABLE `notify_message` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `title` VARCHAR(128) NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '0未读 1已读',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_status` (`user_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='站内消息';
-- ==== /workspace/docs-v3/modules/campaign/db.sql ====

-- 活动与优惠（v3 重设计）

CREATE TABLE `campaign` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1折扣 2满减 3限时',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '0草稿 1生效 2下线',
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `rules` JSON NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动';

CREATE TABLE `campaign_sku` (
  `id` BIGINT NOT NULL,
  `campaign_id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_campaign` (`campaign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动适用SKU';
-- ==== /workspace/docs-v3/modules/content/db.sql ====

-- 内容（v3 重设计）

CREATE TABLE `post` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `title` VARCHAR(128) NOT NULL,
  `content` MEDIUMTEXT NOT NULL,
  `author_id` BIGINT NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子';

CREATE TABLE `comment` (
  `id` BIGINT NOT NULL,
  `post_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';
-- ==== /workspace/docs-v3/modules/device-bridge/db.sql ====

-- 设备桥接（v3 重设计）

CREATE TABLE `device_action_log` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `seat_id` BIGINT NOT NULL,
  `action` TINYINT NOT NULL COMMENT '1开机 2关机 3续费 4查询',
  `request_payload` JSON NULL,
  `response_payload` JSON NULL,
  `success` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_time` (`seat_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备动作日志';
-- ==== /workspace/docs-v3/modules/floor/db.sql ====

-- 楼层与区域（v3 重设计）

CREATE TABLE `floor` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼层';

CREATE TABLE `area` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `floor_id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_floor` (`floor_id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='区域';
-- ==== /workspace/docs-v3/modules/goods/db.sql ====

-- 商品模块（v3 重设计）

CREATE TABLE `goods_category` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(64) NOT NULL,
  `parent_id` BIGINT NOT NULL DEFAULT 0,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_store_parent` (`store_id`,`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品类目';

CREATE TABLE `goods` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(128) NOT NULL,
  `category_id` BIGINT NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1计时 2计次 3耗材 4服务',
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  `version` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_store_cat` (`store_id`,`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品';

CREATE TABLE `goods_sku` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `goods_id` BIGINT NOT NULL,
  `sku_code` VARCHAR(64) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sku_code` (`sku_code`),
  KEY `idx_goods` (`goods_id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品SKU';
-- ==== /workspace/docs-v3/modules/inventory-耗材/db.sql ====

-- 耗材与库存（v3 重设计）

CREATE TABLE `inventory_sku` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `name` VARCHAR(128) NOT NULL,
  `category` VARCHAR(64) NOT NULL DEFAULT '',
  `unit` VARCHAR(16) NOT NULL DEFAULT 'pcs',
  `safety_stock` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_store_cat` (`store_id`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存SKU';

CREATE TABLE `inventory_stock` (
  `sku_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sku_id`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存数量';

CREATE TABLE `inventory_ledger` (
  `id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1入库 2出库 3调整',
  `quantity` INT NOT NULL,
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_sku_time` (`sku_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存流水';
-- ==== /workspace/docs-v3/modules/member/db.sql ====

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
-- ==== /workspace/docs-v3/modules/order/db.sql ====

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
-- ==== /workspace/docs-v3/modules/package-套餐/db.sql ====

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
-- ==== /workspace/docs-v3/modules/pay-bridge/db.sql ====

-- 支付桥接（v3 重设计）

CREATE TABLE `pay_transaction` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `order_id` BIGINT NOT NULL,
  `channel` TINYINT NOT NULL COMMENT '1微信 2支付宝 3钱包',
  `trade_no` VARCHAR(64) NOT NULL,
  `status` TINYINT NOT NULL COMMENT '0创建 1成功 2关闭 3退款',
  `amount` DECIMAL(12,2) NOT NULL,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_trade_no` (`trade_no`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付交易';

CREATE TABLE `pay_notify_log` (
  `id` BIGINT NOT NULL,
  `transaction_id` BIGINT NOT NULL,
  `payload` JSON NULL,
  `received_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_txn` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付回调日志';
-- ==== /workspace/docs-v3/modules/permission/db.sql ====

-- 权限扩展（v3 重设计）

CREATE TABLE `sys_data_scope` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `scope_rule` TINYINT NOT NULL COMMENT '1全部 2本门店 3本人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据范围定义';

CREATE TABLE `sys_role_scope` (
  `role_id` BIGINT NOT NULL,
  `scope_id` BIGINT NOT NULL,
  PRIMARY KEY (`role_id`,`scope_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-数据范围';
-- ==== /workspace/docs-v3/modules/points/db.sql ====

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
-- ==== /workspace/docs-v3/modules/seat/db.sql ====

-- 机位与会话（v3 重设计）

CREATE TABLE `seat` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `area_id` BIGINT NOT NULL,
  `device_no` VARCHAR(64) NOT NULL DEFAULT '',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '1空闲 2占用 3故障',
  PRIMARY KEY (`id`),
  KEY `idx_area` (`area_id`),
  KEY `idx_store_status` (`store_id`,`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位';

CREATE TABLE `seat_session` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `seat_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NULL,
  `duration_sec` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '1进行中 2结束 3取消',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_status` (`seat_id`,`status`),
  KEY `idx_user_time` (`user_id`,`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位会话';
-- ==== /workspace/docs-v3/modules/stats/db.sql ====

-- 数据统计（v3 重设计）

CREATE TABLE `stats_daily_revenue` (
  `biz_date` DATE NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `revenue_total` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `orders` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`biz_date`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每日营收汇总';
-- ==== /workspace/docs-v3/modules/user/db.sql ====

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
-- ==== /workspace/docs-v3/modules/wallet/db.sql ====

-- 钱包模块（v3 重设计）

CREATE TABLE `wallet_account` (
  `user_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `balance` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `frozen` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包账户';

CREATE TABLE `wallet_ledger` (
  `id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `user_id` BIGINT NOT NULL,
  `type` TINYINT NOT NULL COMMENT '1充值 2消费 3退款 4提现 5冻结 6解冻',
  `amount` DECIMAL(12,2) NOT NULL,
  `balance_after` DECIMAL(12,2) NOT NULL,
  `biz_id` VARCHAR(64) NOT NULL DEFAULT '',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`create_time`),
  KEY `idx_store_type` (`store_id`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包流水';
-- ==== END ====


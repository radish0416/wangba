-- ==== /workspace/docs-v3/modules/auth/db.sql ====

-- 认证与权限（账户）
CREATE TABLE `sys_user` (
  `id` BIGINT NOT NULL,
  `username` VARCHAR(64) NOT NULL,
  `password_hash` VARCHAR(128) NOT NULL,
  `display_name` VARCHAR(64) NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='后台账户';

CREATE TABLE `sys_role` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
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

-- 余额与消费记录
CREATE TABLE `consume_record` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL DEFAULT 0,
  `type` VARCHAR(32) NOT NULL COMMENT 'time|goods|package',
  `amount` DECIMAL(12,2) NOT NULL,
  `pay_channel` VARCHAR(16) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费记录';
-- ==== /workspace/docs-v3/modules/base-service/db.sql ====

-- 基础服务
CREATE TABLE `file_object` (
  `id` BIGINT NOT NULL,
  `bucket` VARCHAR(64) NOT NULL,
  `object_key` VARCHAR(255) NOT NULL,
  `content_type` VARCHAR(64) NOT NULL,
  `size` BIGINT NOT NULL,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_bucket_key` (`bucket`,`object_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件对象';

CREATE TABLE `dict_item` (
  `id` BIGINT NOT NULL,
  `dict_type` VARCHAR(64) NOT NULL,
  `label` VARCHAR(64) NOT NULL,
  `value` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典';
-- ==== /workspace/docs-v3/modules/campaign/db.sql ====

-- 活动与优惠
CREATE TABLE `campaign` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `type` VARCHAR(32) NOT NULL COMMENT 'discount|fullcut|limited',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '0草稿 1生效 2下线',
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `rules` JSON NULL COMMENT '规则JSON',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动';
-- ==== /workspace/docs-v3/modules/content/db.sql ====

-- 内容
CREATE TABLE `post` (
  `id` BIGINT NOT NULL,
  `title` VARCHAR(128) NOT NULL,
  `content` MEDIUMTEXT NOT NULL,
  `author_id` BIGINT NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帖子';

CREATE TABLE `comment` (
  `id` BIGINT NOT NULL,
  `post_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `content` VARCHAR(500) NOT NULL,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论';
-- ==== /workspace/docs-v3/modules/device-bridge/db.sql ====

-- 设备桥接
CREATE TABLE `device_action_log` (
  `id` BIGINT NOT NULL,
  `seat_id` BIGINT NOT NULL,
  `action` VARCHAR(16) NOT NULL COMMENT 'open|close|extend|status',
  `request_payload` JSON NULL,
  `response_payload` JSON NULL,
  `success` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_seat_time` (`seat_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备动作日志';
-- ==== /workspace/docs-v3/modules/floor/db.sql ====

-- 楼层与区域
CREATE TABLE `floor` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼层';

CREATE TABLE `area` (
  `id` BIGINT NOT NULL,
  `floor_id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_floor` (`floor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='区域';
-- ==== /workspace/docs-v3/modules/goods/db.sql ====

-- 商品模块
CREATE TABLE `goods_category` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `parent_id` BIGINT NOT NULL DEFAULT 0,
  `sort` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_parent` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品类目';

CREATE TABLE `goods` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `category_id` BIGINT NOT NULL,
  `type` VARCHAR(32) NOT NULL COMMENT 'type: time,count,material,service',
  `status` TINYINT NOT NULL DEFAULT 1,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_cat` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品';

CREATE TABLE `goods_sku` (
  `id` BIGINT NOT NULL,
  `goods_id` BIGINT NOT NULL,
  `sku_code` VARCHAR(64) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sku_code` (`sku_code`),
  KEY `idx_goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品SKU';
-- ==== /workspace/docs-v3/modules/inventory-耗材/db.sql ====

-- 耗材与库存
CREATE TABLE `inventory_sku` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `category` VARCHAR(64) NOT NULL DEFAULT '',
  `unit` VARCHAR(16) NOT NULL DEFAULT 'pcs',
  `safety_stock` INT NOT NULL DEFAULT 0,
  `status` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存SKU';

CREATE TABLE `inventory_stock` (
  `sku_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `quantity` INT NOT NULL DEFAULT 0,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sku_id`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存数量';

CREATE TABLE `inventory_txn` (
  `id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `type` VARCHAR(16) NOT NULL COMMENT 'in|out|adjust',
  `quantity` INT NOT NULL,
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_sku_time` (`sku_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存流水';
-- ==== /workspace/docs-v3/modules/member/db.sql ====

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
-- ==== /workspace/docs-v3/modules/order/db.sql ====

-- 订单模块
CREATE TABLE `order` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `order_type` VARCHAR(32) NOT NULL COMMENT 'time|goods|package',
  `status` VARCHAR(32) NOT NULL COMMENT 'pending|paid|canceled|refunded|closed',
  `total_amount` DECIMAL(10,2) NOT NULL,
  `pay_amount` DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  `pay_channel` VARCHAR(16) NOT NULL DEFAULT '' COMMENT 'wx|ali|wallet',
  `pay_time` DATETIME NULL,
  `external_no` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '外部支付单号',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

CREATE TABLE `order_item` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `sku_id` BIGINT NOT NULL DEFAULT 0,
  `title` VARCHAR(128) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 1,
  `price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细';
-- ==== /workspace/docs-v3/modules/package-套餐/db.sql ====

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
-- ==== /workspace/docs-v3/modules/pay-bridge/db.sql ====

-- 支付桥接
CREATE TABLE `pay_transaction` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `channel` VARCHAR(16) NOT NULL COMMENT 'wx|ali|wallet',
  `trade_no` VARCHAR(64) NOT NULL COMMENT '第三方交易号',
  `status` VARCHAR(16) NOT NULL COMMENT 'init|success|closed|refund',
  `amount` DECIMAL(12,2) NOT NULL,
  `notify_payload` JSON NULL,
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_order` (`order_id`),
  UNIQUE KEY `uk_trade_no` (`trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付交易';
-- ==== /workspace/docs-v3/modules/permission/db.sql ====

-- 权限扩展（数据范围）
CREATE TABLE `sys_data_scope` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `scope_rule` VARCHAR(32) NOT NULL COMMENT 'all|store|self',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据范围定义';

CREATE TABLE `sys_role_scope` (
  `role_id` BIGINT NOT NULL,
  `scope_id` BIGINT NOT NULL,
  PRIMARY KEY (`role_id`,`scope_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-数据范围';
-- ==== /workspace/docs-v3/modules/points/db.sql ====

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
-- ==== /workspace/docs-v3/modules/seat/db.sql ====

-- 机位
CREATE TABLE `seat` (
  `id` BIGINT NOT NULL,
  `area_id` BIGINT NOT NULL,
  `device_no` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '设备编号',
  `status` VARCHAR(16) NOT NULL DEFAULT 'idle' COMMENT 'idle|occupied|fault',
  `current_order_id` BIGINT NOT NULL DEFAULT 0 COMMENT '当前占用订单',
  PRIMARY KEY (`id`),
  KEY `idx_area` (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机位';
-- ==== /workspace/docs-v3/modules/stats/db.sql ====

-- 数据统计（示例汇总表，可由ETL/任务生成）
CREATE TABLE `stats_daily_revenue` (
  `biz_date` DATE NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `revenue_total` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `orders` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`biz_date`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每日营收汇总';
-- ==== /workspace/docs-v3/modules/user/db.sql ====

-- 用户模块
CREATE TABLE `user` (
  `id` BIGINT NOT NULL COMMENT '主键ID',
  `nickname` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '昵称',
  `mobile` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `avatar_url` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
  `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '性别 0未知 1男 2女',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态 0禁用 1启用',
  `wechat_openid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信openid',
  `wechat_unionid` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '微信unionid',
  `level_id` BIGINT NOT NULL DEFAULT 0 COMMENT '会员等级ID（快照）',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` TINYINT NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_mobile` (`mobile`),
  KEY `idx_level` (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';
-- ==== /workspace/docs-v3/modules/wallet/db.sql ====

-- 钱包模块
CREATE TABLE `wallet_account` (
  `user_id` BIGINT NOT NULL,
  `balance` DECIMAL(12,2) NOT NULL DEFAULT 0.00 COMMENT '可用余额',
  `frozen` DECIMAL(12,2) NOT NULL DEFAULT 0.00 COMMENT '冻结金额',
  `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包账户';

CREATE TABLE `wallet_txn` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `type` VARCHAR(16) NOT NULL COMMENT 'recharge|consume|refund|withdraw|freeze|unfreeze',
  `amount` DECIMAL(12,2) NOT NULL,
  `balance_after` DECIMAL(12,2) NOT NULL,
  `biz_id` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '业务单号',
  `remark` VARCHAR(255) NOT NULL DEFAULT '',
  `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`created_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='钱包流水';
-- ==== END ====


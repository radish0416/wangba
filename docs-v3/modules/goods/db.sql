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
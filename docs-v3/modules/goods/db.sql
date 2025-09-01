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
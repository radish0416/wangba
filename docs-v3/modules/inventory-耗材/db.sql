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
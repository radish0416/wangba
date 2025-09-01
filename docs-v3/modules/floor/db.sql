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
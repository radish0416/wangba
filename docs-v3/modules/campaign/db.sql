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
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
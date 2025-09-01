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
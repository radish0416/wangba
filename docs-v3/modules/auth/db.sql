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
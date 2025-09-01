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
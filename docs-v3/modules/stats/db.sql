-- 数据统计（v3 重设计）

CREATE TABLE `stats_daily_revenue` (
  `biz_date` DATE NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `revenue_total` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `orders` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`biz_date`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每日营收汇总';
-- 数据统计（示例汇总表，可由ETL/任务生成）
CREATE TABLE `stats_daily_revenue` (
  `biz_date` DATE NOT NULL,
  `store_id` BIGINT NOT NULL DEFAULT 0,
  `revenue_total` DECIMAL(12,2) NOT NULL DEFAULT 0.00,
  `orders` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`biz_date`,`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每日营收汇总';
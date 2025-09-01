# 项目蓝图与原型交付

本仓库包含系统设计、流程与 ER 图、部署编排（Windows Docker）、Web 管理端 Element-UI 原型，以及微信小程序线框与骨架。

## 结构
```
/docs
  /design
    architecture.md
  /diagrams
    architecture.mmd
    flow.mmd
    er.mmd
/docker
  .env.example
  docker-compose.yml
/web-prototypes
  index.html  # Element-UI 静态原型
/miniapp-prototypes
  app.json
  project.config.json
  pages/home/index.wxml
  pages/home/index.wxss
```

## 图表查看
- 使用 Mermaid 支持的查看器或 VS Code 扩展打开 `docs/diagrams/*.mmd`
  - 业务流程：`flow.mmd`
  - 架构图：`architecture.mmd`
  - ER 图：`er.mmd`

## 后端架构说明
- 详见 `docs/design/architecture.md`（Spring Boot 单体、MySQL/Redis/MinIO，对接支付与设备监控）。

## 本地部署（Windows / Docker Desktop）
1. 复制环境变量示例
   ```bash
   cd docker
   cp .env.example .env
   ```
2. 启动中间件
   ```bash
   docker compose up -d
   ```
3. 访问
   - MySQL: 127.0.0.1:${MYSQL_PORT}
   - Redis: 127.0.0.1:${REDIS_PORT}
   - MinIO: 控制台 http://127.0.0.1:${MINIO_CONSOLE_PORT} ，API http://127.0.0.1:${MINIO_PORT}

## Web 管理端原型
- 打开 `web-prototypes/index.html` 即可查看基于 Element-UI 的静态页面原型（仪表盘、商品列表、订单列表占位）。

## 微信小程序原型
- 使用微信开发者工具打开 `miniapp-prototypes` 目录。
- `wireframes.mmd` 提供了页面线框流程。

## 约定
- 数据库字段统一驼峰命名。
- 缓存使用 Redis；对象存储使用 MinIO。
- 支付与设备监控仅对接，不在本项目中实现。

## 架构与项目设计（单体应用 / Spring Boot）

### 技术选型
- 后端（单体）：Spring Boot 3.x、Spring Web, Spring Validation, Spring Data JPA 或 MyBatis-Plus（二选一）、Spring Cache (Redis)、Spring Security (JWT)、Lombok、MapStruct（可选）
- 数据库：MySQL 8.x（字段命名驼峰）
- 缓存：Redis 7.x
- 对象存储：MinIO（S3 兼容）
- 外部对接：支付服务、设备监控平台（仅对接，不在本项目内实现）
- 前端：Web（Element-UI/Vue 2 或 Element Plus/Vue 3，原型为静态页面）、微信小程序（原型/骨架）
- 部署：Docker（Windows 环境），docker-compose 管理 MySQL/Redis/MinIO

### 分层设计
- 接口层（`controller`）：提供 REST API（JSON），参数校验，鉴权入口
- 应用/领域层（`service`）：业务编排、领域逻辑、跨资源事务
- 仓储层（`repository`）：面向聚合根的数据访问，JPA/MyBatis 隔离 SQL
- 基础设施（`infra`）：第三方集成（MinIO、支付、设备平台）、消息、邮件等
- 接口契约（`dto`）：请求/返回数据对象，避免直接暴露实体
- 领域模型（`domain`）：实体、值对象、枚举

### 目录结构（建议）
```
server
 └── src
     ├── main
     │   ├── java/com/yourcompany/yourapp
     │   │   ├── YourAppApplication.java
     │   │   ├── config/            # 跨域、Swagger、Jackson、Redis、MinIO 等配置
     │   │   ├── security/          # JWT、认证鉴权
     │   │   ├── controller/        # 控制器
     │   │   ├── service/           # 业务服务接口与实现
     │   │   ├── domain/            # 领域模型（entity、vo、enum）
     │   │   ├── repository/        # JPA/MyBatis 映射、DAO
     │   │   ├── dto/               # 请求/响应 DTO
     │   │   ├── infra/             # MinIO 客户端、支付/设备对接适配器
     │   │   └── util/              # 工具类
     │   └── resources
     │       ├── application.yml    # 多环境配置 application-{env}.yml
     │       └── db/migration/      # Flyway/Liquibase 脚本（可选）
     └── test/java/...              # 单元测试/集成测试
```

### 模块边界（示例）
- 用户与认证：注册、登录、Token 刷新、用户信息
- 商品与库存：商品 CRUD、库存查询与预扣减（Redis 缓存）
- 订单与支付：下单、支付单创建、回调处理（仅对接）
- 文件与对象存储：上传凭证、回传校验、持久化对象元数据（MinIO）

### 数据模型（概要）
详见 `docs/diagrams/er.mmd`，字段均为驼峰命名。

### 缓存策略
- 热点商品与库存：Redis Key 按 `product:ID`、`stock:ID`，设置合理 TTL 与一致性策略（写后删缓存/延迟双删）
- 会话/Token：服务端无状态（JWT）为主，可选 Redis 存储黑名单

### 对象存储策略
- 通过后端签名（预签名 URL 或策略）直传 MinIO，后端持久化对象元数据并与业务实体关联
- 桶与对象 Key 命名：`app-public/`、`app-private/`，Key 按业务分层（如 `avatar/uid/file.ext`）

### 安全与鉴权
- JWT Bearer；接口按角色/权限保护；重要操作审计日志
- 输入校验（JSR-380），输出统一响应包装与错误码

### 配置与环境
- Windows 开发：通过 docker-compose 启动 MySQL/Redis/MinIO
- 应用本地运行连接容器服务；生产环境变量注入敏感配置（DB、Redis、MinIO、支付）

### 日志与可观测性
- 结构化日志（JSON 可选）、HTTP 访问日志、业务审计
- Spring Boot Actuator 健康检查与指标暴露（/actuator/health, /metrics）

### 构建与质量
- Maven 或 Gradle；Checkstyle/Spotless；单元/集成测试

### 关键时序（示例）
详见 `docs/diagrams/flow.mmd`：下单与支付、文件上传、库存查询


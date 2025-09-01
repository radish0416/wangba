### 网吧项目实现方案 V2（约束更新）

本版根据业务方补充：对接设备监控与支付；后端为 Java + Spring Boot 单体；MySQL（驼峰）、Redis、MinIO；小程序前端；Docker 部署；Windows 宿主。

- 参考架构：`docs/plan/architecture/2025-09-01_system-architecture.md`
- 核心流程：`docs/specs/flows/2025-09-01_core-flows.md`
- ER 图：`docs/specs/er/2025-09-01_er-diagram.md`

#### 范围调整
- 设备监控：仅对接（Webhook/REST/MQTT），不自研。
- 支付：对接微信/支付宝，不自研钱包；仅保存第三方回执。

#### 技术实现
- Spring Boot 模块化：`order`、`seat`、`promotion`、`review`、`integration-device`、`integration-payment`、`admin`、`minio`、`auth`。
- 数据：MySQL（驼峰命名）；Flyway 管理迁移；Redis 用于会话、幂等、锁；MinIO 存储上传文件与导出。
- 小程序：原生/TS；接口鉴权基于 session + token；支付走 JSAPI。
- 部署：Compose/Dockerfile；Windows 宿主适配。

#### 里程碑（重排）
- M1：订单最小闭环 + 支付对接 + 座位/区域模型
- M2：设备对接与会话联动 + 管理端基础
- M3：退款与对账 + 活动/评价
- M4：3D 导览入口与占用态联动（如需）

#### 验收标准
- 小程序完成选座/下单/支付；订单状态与设备会话联动
- 管理端完成订单与座位管理；可配置对接参数
- 数据一致：支付/退款回执入库，可回放与追踪
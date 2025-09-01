# 文档索引（v3）

- 分支：`docs-v3`（在 git 分支 docs-v3 上维护）
- 标准：MyBatis-Plus（XML 写 SQL）+ Swagger/OpenAPI + MVC 分层 + POST-only
- 规范：Alibaba Java 开发手册；DTO/VO/PO 分离；统一返回；分页/全量；全字段动态条件查询
- 范围：补全“会员、商品、积分、楼层、余额、消费记录、套餐、权限、耗材（库存）、基础服务、支付/设备对接”等模块，并补齐原型与流程图占位

## 目录结构
```
docs-v3
 ├─ README-索引.md
 ├─ 后端编码与规范-MyBatisPlus-Swagger-MVC-第3版.md
 ├─ diagrams/
 │   └─ 域模块总览.svg
 ├─ web-wireframes/
 │   └─ index.md
 ├─ miniapp-wireframes/
 │   └─ index.md
 ├─ frontend/
 │   ├─ README-索引.md
 │   ├─ web-admin/设计-后台管理端.md
 │   ├─ miniapp/设计-小程序端.md
 │   └─ shared/设计系统与规范.md
 ├─ database/
 │   ├─ 数据库设计-汇总.md
 │   └─ schema-aggregated.sql
 └─ modules/
     ├─ auth/
     ├─ permission/
     ├─ user/
     ├─ member/
     ├─ points/
     ├─ order/
     ├─ seat/
     ├─ floor/
     ├─ goods/
     ├─ package-套餐/
     ├─ inventory-耗材/
     ├─ wallet/
     ├─ balance/
     ├─ campaign/
     ├─ stats/
     ├─ content/
     ├─ pay-bridge/
     ├─ device-bridge/
     └─ base-service/
```

## 快速入口
- 后端规范：`后端编码与规范-MyBatisPlus-Swagger-MVC-第3版.md`
- 前端设计：`frontend/README-索引.md`
- 数据库：`database/数据库设计-汇总.md`、`database/schema-aggregated.sql`
- 域模块总览：`diagrams/域模块总览.svg`
- 模块文档：`modules/*`（每个模块包含 文档、流程图、数据库设计、原型链接）
- 原型导航：`web-wireframes/index.md`、`miniapp-wireframes/index.md`
- 历史文档：`docs/` 与 `docs-v2/` 作为参考归档

— 完 —
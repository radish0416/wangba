# 前端设计（v3）索引

- 子目录：
  - `web-admin/`：后台管理端（PC）
  - `miniapp/`：微信小程序端（C端）
  - `shared/`：设计系统与通用规范

- 总体约束：
  - 全部通过后端 POST 接口（OpenAPI/Swagger 对齐）
  - 统一错误处理与登录态校验，环境变量区分多环境
  - API 层代码由 OpenAPI 生成器产出，避免重复手写

— 完 —
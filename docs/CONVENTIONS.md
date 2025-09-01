### 文档命名与归档规范

- **目录结构**
  - `docs/plan/`：高阶方案、里程碑路线图
  - `docs/specs/`：详细需求与接口/数据模型等说明
  - `docs/api/`：对外/内部 API 文档与 SDK 用法
  - `docs/adr/`：Architecture Decision Record（架构决策记录）
  - `docs/logs/`：沟通纪要、问题澄清、周报
  - `docs/prototypes/`：原型、示意图与外链说明（图片可外链或后续补齐）

- **文件命名**（全部小写、短横线连接）
  - 前缀为日期：`YYYY-MM-DD`
  - 语义化主题：`主题-关键词`
  - 示例：`2025-09-01_wangba-project-implementation-plan-v1.md`

- **沟通纪要模板**（存放于 `docs/logs/`）
  - 标题：`YYYY-MM-DD_session-序号.md`
  - 内容结构：
    - 背景/问题
    - 结论/决定
    - 待办/风险
    - 关联文件链接

- **ADR 模板**（存放于 `docs/adr/`）
  - 文件名：`YYYY-MM-DD_决策主题.md`
  - 内容：背景、可选方案、取舍、决定、影响面、回滚策略

- **文档更新原则**
  - 任何影响范围>1个模块的变更，必须新增/更新 ADR。
  - 本项目的每次讨论输出，均以沟通纪要形式落档到 `docs/logs/`。
  - README 仅保留导航链接与重要入口，细节放入对应文档。
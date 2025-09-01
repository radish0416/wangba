### 后台 Web 原型大纲（Element-UI 风格）

- **信息架构（导航）**
  - 仪表盘（上座率、营业额、订单/支付状态）
  - 门店/区域/座位
  - 订单管理
  - 活动与优惠
  - 用户与评价
  - 集成设置（设备监控、支付渠道）
  - 3D 场景配置（热点/路径/占用态来源）
  - 系统设置（员工与权限、字典、日志）

- **核心页面草图说明**
  - 仪表盘：`el-row` 卡片 + `el-table` 最近订单 + 图表（ECharts）
  - 座位管理：楼层/区域树（`el-tree`）+ 座位平面图（网格/标记）+ 侧栏详情
  - 订单列表：筛选（时间/门店/状态）+ 列表 + 详情抽屉（退款、回放）
  - 活动：列表 + 规则编辑器（表单+规则 JSON 预览）
  - 集成设置：设备监控回调 URL、签名密钥；支付商户号/证书上传（存 MinIO）

- **组件清单**
  - 表单：`el-form`、`el-form-item`、`el-input`、`el-select`、`el-upload`
  - 布局：`el-container`、`el-aside`、`el-header`、`el-main`
  - 反馈：`el-dialog`、`el-drawer`、`el-message`、`el-notification`
  - 数据展示：`el-table`、`el-card`、`el-tag`、`el-badge`

> 后续可将每个页面细化为低保真图并导出 PNG 存放于该目录。
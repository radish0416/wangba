### 小程序原型（Figma 大纲）

- **项目链接**：待创建（占位）。建议以 Figma 页面组织如下：

- **页面/Frame 列表**
  - Home：门店入口、活动 Banner、排行榜入口
  - Store：门店信息、区域列表、3D 导览入口
  - SeatSelect：区域座位网格、占用态、时间选择
  - OrderConfirm：订单确认、价格明细、活动抵扣
  - Payment：拉起微信支付、结果态（成功/失败）
  - My：我的订单、评价、消息、设置
  - OrderDetail：订单进度、设备会话状态
  - Review：评价打分与文字

- **组件库**
  - 按钮/按钮组、卡片、标签、Tab、表单项、结果页、空状态

- **交互要点**
  - 入口：从 Home 到 Store/SeatSelect
  - 下单：SeatSelect -> OrderConfirm -> Payment -> 回到 OrderDetail
  - 通知：支付结果与订单状态通过订阅消息/轮询同步

> Figma 建议：为每个 Frame 添加变体（Variant）以覆盖状态/禁用/加载，后续可以导出切图存放至 MinIO。
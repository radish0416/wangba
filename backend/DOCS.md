网吧管理系统后端设计说明

模块
- 用户与权限：用户、角色、登录、管理员创建商家/用户
- 会员：等级、积分、优惠权益
- 订单：下单、退单、提醒、状态流转
- 积分：签到、消费换积分、积分兑时长
- 优惠：满减、时段折扣（规则JSON存储）
- 商品/库存：商品、库存、低库存自动下架
- 消费记录：按人/设备留存
- 消息：通知、故障提醒
- 支付：对接收银系统（适配器）
- 设备控制：对接监控/开关机系统（适配器）

数据库规范
- 表名、字段名使用驼峰（示例：OrderRecord、memberId）
- 每表预留 extA~extE 五个扩展字段
- 金额以分 amountFen，时长以秒 durationSeconds

统一返回
- ApiResponse{ code, message, data }，成功 code=0

部署
1. 生产使用 MySQL 8，配置 spring.datasource.*
2. 配置 JWT 秘钥 app.jwt.secret
3. 构建：mvn clean package
4. 运行：java -jar netbar-backend-1.0.0.jar
5. Nginx 反代 /api/* 到 8080，开启 HTTPS

对接
- 收银与设备控制通过 CashierPaymentClient、DeviceControlClient 适配器接口，生产替换 Mock 实现。


### 系统架构（Spring Boot 单体 + 对接方案）

```mermaid
flowchart TB
  subgraph Client[客户端]
    MP[微信小程序]
    Admin[后台 Web (Element-UI)]
  end

  subgraph App[Spring Boot 单体应用]
    API[REST API]
    Order[订单模块]
    Seat[门店/区域/座位模块]
    Promo[活动/优惠模块]
    Review[评价/消息模块]
    Integrations[集成模块]
  end

  subgraph Integrations[外部系统]
    DeviceSys[设备监控系统(对接)]
    PaySys[支付(微信/支付宝) 对接]
  end

  subgraph Storage[存储]
    MySQL[(MySQL)]
    Redis[(Redis)]
    MinIO[(MinIO)]
  end

  MP -->|HTTPS| API
  Admin -->|HTTPS| API

  API --> Order
  API --> Seat
  API --> Promo
  API --> Review
  API --> Integrations

  Integrations -->|Webhook/REST/MQTT| DeviceSys
  Integrations -->|JSAPI/Native| PaySys

  App <--> MySQL
  App <--> Redis
  App --> MinIO

  subgraph Deploy[部署/运行]
    Windows[Windows Host]
    Docker[Docker]
  end

  App -.container.-> Docker
  MySQL -.container.-> Docker
  Redis -.container.-> Docker
  MinIO -.container.-> Docker
  Docker --> Windows
```

- 单体应用按领域模块化，暴露统一 REST API。
- 对接设备监控采用 Webhook 首选，REST/MQTT 作为补充；支付采用微信/支付宝官方 SDK。
- 所有服务以容器运行，宿主为 Windows。
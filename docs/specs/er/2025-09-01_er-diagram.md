### ER 图（MySQL，驼峰命名）

```mermaid
erDiagram
  user ||--o{ order : places
  user ||--o{ review : writes
  merchant ||--o{ store : owns
  store ||--o{ zone : consists
  zone ||--o{ seat : contains
  seat ||--|| deviceBinding : has
  order ||--|{ orderItem : includes
  order ||--o| paymentRecord : paidBy
  order ||--o{ refundRecord : mayHave
  store ||--o{ promotion : offers

  user {
    bigint id PK
    varchar nickname
    varchar phone
    varchar wechatOpenId
    datetime createdAt
    datetime updatedAt
  }

  merchant {
    bigint id PK
    varchar name
    datetime createdAt
    datetime updatedAt
  }

  store {
    bigint id PK
    bigint merchantId FK
    varchar name
    varchar address
    varchar phone
    json businessHours
    datetime createdAt
    datetime updatedAt
  }

  zone {
    bigint id PK
    bigint storeId FK
    varchar name
    int floor
    int seatCount
    datetime createdAt
    datetime updatedAt
  }

  seat {
    bigint id PK
    bigint zoneId FK
    varchar code
    varchar label
    varchar status
    datetime createdAt
    datetime updatedAt
  }

  deviceBinding {
    bigint id PK
    bigint seatId FK
    varchar deviceCode
    varchar extRef
    datetime createdAt
    datetime updatedAt
  }

  order {
    bigint id PK
    bigint userId FK
    bigint storeId FK
    bigint zoneId FK
    bigint seatId FK
    varchar status
    datetime startTime
    datetime endTime
    decimal amount 10,2
    varchar payChannel
    varchar payTradeNo
    datetime createdAt
    datetime updatedAt
  }

  orderItem {
    bigint id PK
    bigint orderId FK
    varchar itemType
    varchar itemRef
    int quantity
    decimal price 10,2
  }

  paymentRecord {
    bigint id PK
    bigint orderId FK
    varchar channel
    varchar prepayId
    varchar tradeNo
    varchar status
    json notifyPayload
    datetime createdAt
  }

  refundRecord {
    bigint id PK
    bigint orderId FK
    varchar channel
    varchar refundNo
    varchar status
    json notifyPayload
    datetime createdAt
  }

  review {
    bigint id PK
    bigint userId FK
    bigint storeId FK
    bigint orderId FK
    int rating
    varchar content
    datetime createdAt
  }

  promotion {
    bigint id PK
    bigint storeId FK
    varchar name
    varchar type
    json rules
    datetime startTime
    datetime endTime
    tinyint enabled
  }
```

> 说明：支付仅记录第三方对接回执，不维护内部钱包账户。
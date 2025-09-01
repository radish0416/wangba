# 后端编码与规范 - 第3版

- 语言/框架: Java 17+, Spring Boot 3.x（单体）
- ORM: MyBatis-Plus（所有 SQL 写在 XML）
- 文档: Swagger/OpenAPI（springdoc-openapi）
- 结构: MVC + 分层（controller/service/service-impl/repository/mapper/domain）
- 规范: Alibaba Java 开发手册（强制/推荐），注释全面（类/方法/字段）
- DTO/VO/PO 分离：po 持久对象；dto 入参；vo 出参
- 所有接口仅使用 POST；统一返回包装；分页+全量查询；全字段动态条件查询；多用注解

## 一、项目结构建议
```
com.cybercafe
 ├─ common (统一返回/异常/枚举/转换器/分页模型)
 ├─ config (swagger/mybatis-plus/redis/minio/cors)
 ├─ domain (po 对象、枚举)
 ├─ repository (mapper 接口 + xml)
 ├─ service (接口 + impl)
 ├─ web (controller, vo, dto, 校验)
 └─ util (雪花ID、Bean 拷贝、时间、加解密)
```

## 二、统一返回模型
```java
/** 统一返回包装 */
public class ApiResponse<T> {
    /** 0=成功 其它=错误码 */
    private Integer code;
    /** 提示信息 */
    private String message;
    /** 载荷 */
    private T data;
    public static <T> ApiResponse<T> ok(T data) { /* impl */ return null; }
    public static <T> ApiResponse<T> fail(int code, String msg) { /* impl */ return null; }
}
```
- 错误码划分：10xxx 通用；20xxx 认证授权；30xxx 订单计费；40xxx 支付对接；50xxx 存储/文件

## 三、分页与全量查询
- 统一分页入参：`PageDTO { current, size }`
- 返回：`PageVO<T> { total, pages, current, size, records }`
- 所有列表接口提供：`/listPage`（分页）、`/listAll`（全量，限制上限，默认1000）

## 四、全字段动态条件查询
- 每个模块提供 `QueryDTO`，包含所有可筛选字段
- XML 使用 `<if test="...">` 追加条件；避免拼接空条件
```xml
<select id="selectByDynamic" resultType="po.UserPO">
  SELECT * FROM user
  <where>
    <if test="nickname != null and nickname != ''">
      AND nickname LIKE CONCAT('%', #{nickname}, '%')
    </if>
    <if test="mobile != null and mobile != ''">
      AND mobile = #{mobile}
    </if>
    <if test="status != null">
      AND status = #{status}
    </if>
  </where>
  ORDER BY id DESC
</select>
```

## 五、Swagger 文档
- 依赖：`springdoc-openapi-starter-webmvc-ui`
- 访问：`/swagger-ui.html`（生产关闭）
- 注解：`@Tag`, `@Operation`, `@Schema`, `@Parameter`

## 六、Controller 约定（POST-only）
- 前缀：`/api/{module}`
- 典型接口：`/create` `/update` `/delete` `/detail` `/listPage` `/listAll` `/export`
- 入参：`@RequestBody DTO` + `@Validated`（分组校验）
- 出参：`ApiResponse<VO>` 或 `ApiResponse<PageVO<VO>>`

## 七、MyBatis-Plus 配置
- 分页插件、乐观锁插件、逻辑删除
- Mapper XML：`resources/mapper/{module}/*.xml`
- 命名：表与字段驼峰；`isDeleted` 逻辑删除；`createTime/updateTime` 自动填充

## 八、注释与代码风格
- 全面 Javadoc：类、方法、字段、枚举都需注释
- 控制器轻薄，业务在 Service；参数校验到 DTO；VO 不泄漏内部字段
- 单行不超 120 列；常量全大写下划线；避免魔法值；优先早返回

## 九、示例接口（用户模块）
```java
@RestController
@RequestMapping("/api/user")
@Tag(name = "用户管理")
public class UserController {
    @PostMapping("/listPage")
    @Operation(summary = "分页查询用户")
    public ApiResponse<PageVO<UserVO>> listPage(@RequestBody UserQueryDTO dto) { return null; }

    @PostMapping("/listAll")
    @Operation(summary = "全量查询用户")
    public ApiResponse<List<UserVO>> listAll(@RequestBody UserQueryDTO dto) { return null; }
}
```

## 十、统一异常与日志
- 全局异常：`@RestControllerAdvice` 捕获并转换为 `ApiResponse.fail`
- 审计日志：操作者、IP、UA、耗时、结果；关键链路打点

## 十一、安全与权限
- 登录鉴权（微信/后台账号）、RBAC、门店级数据隔离；跨域与安全头配置

— 完 —
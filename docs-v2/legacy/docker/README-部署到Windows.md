# Windows 部署指引（Docker）

## 前置
- 安装 Docker Desktop for Windows，并开启 WSL2 后端
- 克隆仓库并切换到 `docs` 分支

## 启动命令
```bash
cd docs/docker
# 首次准备目录
mkdir -p data/mysql data/redis data/minio server
# 将后端打包产物拷贝为 app.jar
# 例如: mvn -DskipTests package && cp target/*.jar docs/docker/server/app.jar

# 启动所有服务
docker compose up -d

# 查看日志
docker compose logs -f | cat
```

## 连接串与默认值
- MySQL: `jdbc:mysql://localhost:3306/cybercafe?useSSL=false&serverTimezone=Asia/Shanghai`
- Redis: `redis://localhost:6379`
- MinIO: `http://localhost:9000` 控制台 `http://localhost:9001`
  - AccessKey: `minioadmin`  SecretKey: `minioadmin`

## Spring Boot (docker profile) 示例
在 `application-docker.yml` 中：
```yaml
spring:
  datasource:
    url: jdbc:mysql://mysql:3306/cybercafe?useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: Root@123456
  redis:
    host: redis
    port: 6379
minio:
  endpoint: http://minio:9000
  accessKey: minioadmin
  secretKey: minioadmin
  bucket: cybercafe
server:
  port: 8080
```

## 常见问题
- 如果端口被占用，修改 `docker-compose.yml` 中的宿主机端口映射
- MinIO 首次登录创建桶 `cybercafe`，用于上传 3D 模型/贴图
- Windows 防火墙可能拦截端口，请允许 Docker 应用通信
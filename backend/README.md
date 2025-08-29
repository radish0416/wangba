Netbar Backend (Spring Boot)

Run locally
1. Install Java 17 and Maven.
2. Build and run: `mvn spring-boot:run`.
3. API docs at `/swagger`.

Database
- Defaults to in-memory H2 (MySQL mode). Configure MySQL via `application.yml` when deploying.

Packaging
- `mvn clean package` then run the generated jar.

Deployment
- Provide JVM opts and environment variables for DB and JWT secret. Example systemd unit is included in project docs later.


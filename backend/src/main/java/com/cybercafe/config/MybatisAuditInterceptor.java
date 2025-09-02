package com.cybercafe.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Map;

/**
 * MyBatis 拦截器：自动填充审计字段（createBy/createTime/updateBy/updateTime）。
 * 说明：真实环境应从登录上下文获取 userId 与 storeId。
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MybatisAuditInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if ("update".equals(invocation.getMethod().getName())) {
            Object parameter = invocation.getArgs()[1];
            if (parameter instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) parameter;
                Object entity = map.get("et");
                Object param1 = map.get("param1");
                touchAudit(entity, param1);
            } else {
                touchAudit(parameter, null);
            }
        }
        return invocation.proceed();
    }

    private void touchAudit(Object entity, Object extra) {
        if (entity == null) {
            return;
        }
        try {
            LocalDateTime now = LocalDateTime.now();
            Long userId = 0L; // TODO: 从登录上下文注入
            Class<?> clazz = entity.getClass();
            // createTime/createBy
            try {
                clazz.getMethod("getCreateTime");
                clazz.getMethod("setCreateTime", LocalDateTime.class).invoke(entity, now);
            } catch (Exception ignored) {}
            try {
                clazz.getMethod("getCreateBy");
                clazz.getMethod("setCreateBy", Long.class).invoke(entity, userId);
            } catch (Exception ignored) {}
            // updateTime/updateBy
            try {
                clazz.getMethod("getUpdateTime");
                clazz.getMethod("setUpdateTime", LocalDateTime.class).invoke(entity, now);
            } catch (Exception ignored) {}
            try {
                clazz.getMethod("getUpdateBy");
                clazz.getMethod("setUpdateBy", Long.class).invoke(entity, userId);
            } catch (Exception ignored) {}
        } catch (Exception ignored) { }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) { }
}

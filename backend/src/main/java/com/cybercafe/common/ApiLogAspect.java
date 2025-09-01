package com.cybercafe.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 接口日志切面，记录请求耗时与结果概览。
 */
@Aspect
@Configuration
public class ApiLogAspect {
    private static final Logger log = LoggerFactory.getLogger(ApiLogAspect.class);

    /**
     * 环绕拦截控制器方法。
     * @param pjp 连接点
     * @return 结果
     * @throws Throwable 异常
     */
    @Around("execution(public * com.cybercafe.web.controller..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object result = pjp.proceed();
            long cost = System.currentTimeMillis() - start;
            log.info("api={} costMs={}", pjp.getSignature().toShortString(), cost);
            return result;
        } catch (Throwable t) {
            long cost = System.currentTimeMillis() - start;
            log.error("api={} costMs={} err={}", pjp.getSignature().toShortString(), cost, t.getMessage(), t);
            throw t;
        }
    }
}
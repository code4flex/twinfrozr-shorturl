package com.twinfrozr.shorturl.core.aspect;

import com.twinfrozr.shorturl.common.utils.ServletUtils;
import com.twinfrozr.shorturl.common.utils.StringUtils;
import com.twinfrozr.shorturl.core.annotation.RecordLogger;
import com.twinfrozr.shorturl.core.task.AsyncTasks;
import com.twinfrozr.shorturl.core.task.TasksManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 短链访问记录
 * 
 * @author marvin
 */
@Aspect
@Component
public class LogRecordAspect
{
    private static final Logger log = LoggerFactory.getLogger(LogRecordAspect.class);

    /**
     * 配置切点
     */
    @Pointcut("@annotation(com.twinfrozr.shorturl.core.annotation.RecordLogger)")
    public void logRecordPointCut() { }

    /**
     * 处理完请求后处理
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logRecordPointCut()")
    public void doAfterReturning(JoinPoint joinPoint)
    {
        handleLogRecord(joinPoint, null);
    }

    /**
     * 拦截异常处理
     * 
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logRecordPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLogRecord(joinPoint, e);
    }

    /**
     * 日志处理
     * @param joinPoint
     * @param e
     */
    protected void handleLogRecord(final JoinPoint joinPoint, final Exception e)
    {
        try {
            RecordLogger recordLogger = getAnnotationLog(joinPoint);
            if (null == recordLogger) {
                return;
            }
            String url = ServletUtils.getRequest().getRequestURL().toString();
            Map map = (Map) ServletUtils.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            String code = (String) map.get("code");

            // 执行task
            TasksManager.me().execute(AsyncTasks.logRecordHandler(code,url));
        }
        catch (Exception exp) {
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private RecordLogger getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (null != method) {
            return method.getAnnotation(RecordLogger.class);
        }
        return null;
    }
}

package com.twinfrozr.shorturl.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义短链访问记录注解
 *
 * @author mavin
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordLogger {

    public String name() default "";

    public boolean isSaveRequestParams() default true;
}

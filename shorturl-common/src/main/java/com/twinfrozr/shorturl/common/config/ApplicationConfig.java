package com.twinfrozr.shorturl.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序注解配置
 *
 * @author marvin
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.twinfrozr.shorturl.**.mapper")
public class ApplicationConfig
{

}

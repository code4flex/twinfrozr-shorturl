package com.twinfrozr.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author marvin
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RestfulApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RestfulApplication.class, args);
    }
}
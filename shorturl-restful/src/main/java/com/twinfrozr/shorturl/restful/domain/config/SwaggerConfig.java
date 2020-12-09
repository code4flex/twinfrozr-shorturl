package com.twinfrozr.shorturl.restful.domain.config;

import com.twinfrozr.shorturl.common.config.ShorturlConfig;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * 
 * @author marvin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Value("${swagger.enabled}")
    private boolean enabled;
    
    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("短链系统_接口文档")
                .description("短链系统Restful 接口文档")
                .contact(new Contact(ShorturlConfig.getName(), null, null))
                .version("版本号:" + ShorturlConfig.getVersion())
                .build();
    }
}

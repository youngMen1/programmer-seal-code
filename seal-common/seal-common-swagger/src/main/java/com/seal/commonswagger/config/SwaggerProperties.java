package com.seal.commonswagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/8/20 14:47
 * @description
 **/
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "";

    /**
     * 标题
     **/
    private String title = "";
    /**
     * 描述
     **/
    private String description = "";
    /**
     * 版本
     **/
    private String version = "";
}

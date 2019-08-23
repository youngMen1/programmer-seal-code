package com.seal.commonswagger.annotation;

import com.seal.commonswagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/7/23 11:57
 * @description 开启swagger
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSealSwagger2 {
}

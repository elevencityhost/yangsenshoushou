package com.winter.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置swaggerUI
 * @author 十一城城主
 * @data 2018/1/24 9:32
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.winter.controller")
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.winter.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    /**
    　　* @Description: 创建ApiInfo对象
    　　* @author 十一城城主
    　　* @date 2018/1/24 9:54
    　　*/
    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfoBuilder().title("SpringBoot整合SwaggerUI")
                .description("养森瘦瘦项目使用SwagerUI暴露接口")
                .license("MIT").licenseUrl("http://opensource.org/licenses/MIT")
                .contact(new Contact("十一城城主", "https://github.com/elevencityhost/yangsenshoushou", "15901506742@163.com"))
                .version("1.0")
                .build();
        return apiInfo;
    }
}

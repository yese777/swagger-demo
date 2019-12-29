package com.yese.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(Environment environment) {

        //设置要显示swagger的环境
        Profiles profiles = Profiles.of("dev", "test");
        //判断当前环境是否为要显示swagger的环境
        boolean flag = environment.acceptsProfiles(profiles);
        //System.out.println("当前环境是否开启swagger:" + flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组
                .groupName("yese")
                //是否开启
                //.enable(flag)
                //此处因没有配置多环境,所以直接开启
                .enable(true)
                .select()
                //RequestHandlerSelectors:配置要扫描的接口的方式,basePackage扫描包
                .apis(RequestHandlerSelectors.basePackage("com.yese.controller"))
                //过滤路径
                .paths(PathSelectors.any())
                .build();
        //return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 使用 Swagger2 构建RESTful API")
                //作者信息
                .contact(new Contact("yese", "http://www.baidu.com/", "1321810135@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }


    //分组,合作开发
    @Bean
    public Docket group1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("张三");
    }

}

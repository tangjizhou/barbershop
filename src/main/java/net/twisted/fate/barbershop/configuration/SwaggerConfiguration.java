package net.twisted.fate.barbershop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("jpa项目学习").description("jpa项目学习")
                .license("The Apache License, Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("http://my.csdn.net/elvishehai").build();

        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.basePackage("net.twisted.fate.barbershop.controller"))
                .build().apiInfo(apiInfo);
    }

}

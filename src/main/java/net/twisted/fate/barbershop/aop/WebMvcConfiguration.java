package net.twisted.fate.barbershop.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * web配置
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserArgumentResolver());
    }

}

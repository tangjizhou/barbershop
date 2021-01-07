package net.twisted.fate.barbershop.aop;

import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.enumeration.Sex;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 用户字段注入
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory)
            throws Exception {
        return new User("唐继洲", 26, Sex.MALE);
    }

}

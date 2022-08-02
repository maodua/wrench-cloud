package io.github.maodua.common.security.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.github.maodua.common.security.util.ContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 请求拦截器
 */
@Configuration
public class FeignConfig {

    /**
     * 请求拦截器 <br/>
     * 如果用户登录则传递用户信息
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return (RequestTemplate template) -> {
            String userId = ContextHolder.getUserId();
        if (StringUtils.isNotBlank(userId)) {
            template.header(ContextHolder.USER_ID, ContextHolder.getUserId());
            template.header(ContextHolder.LOGIN, String.valueOf(ContextHolder.isLogin()));
        }
        };
    }
}

package io.github.maodua.common.security.interceptor;

import io.github.maodua.common.security.util.ContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求Header拦截器
 */
@Component
public class HeaderInterceptor implements AsyncHandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user_id = request.getHeader(ContextHolder.USER_ID);
        if (StringUtils.isNotBlank(user_id)) {
            ContextHolder.set(ContextHolder.USER_ID, user_id);
            ContextHolder.set(ContextHolder.LOGIN, true);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ContextHolder.remove();
    }
}

package io.github.maodua.common.security.util;

import org.apache.commons.lang3.BooleanUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 获取当前线程变量中的 用户id、用户名称、Token等信息
 * 注意： 必须在网关通过请求头的方法传入，同时在HeaderInterceptor拦截器设置值。 否则这里无法获取
 *
 * @author ruoyi
 */
public class ContextHolder {
    public static final String USER_ID = "USER_ID";
    public static final String LOGIN = "LOGIN";
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();
    public static String getUserId() {
        if (ContextHolder.get(USER_ID) == null) {
            return null;
        }
        return ContextHolder.get(USER_ID).toString();
    }

    public static boolean isLogin() {
        if (ContextHolder.get(LOGIN) == null) {
            return false;
        }
        return BooleanUtils.toBoolean(ContextHolder.get(LOGIN).toString());
    }


    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = getLocalMap();
        return map.get(key);
    }


    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new ConcurrentHashMap<String, Object>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}

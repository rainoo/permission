package com.gittoy.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 通过ApplicationContext获取Spring管理的Bean。
 * Create by GaoYu 2017/11/21 18:38
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T popBean(Class<T> clazz) {
        return applicationContext == null ? null : applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name, Class<T> clazz) {
        return applicationContext == null ? null : applicationContext.getBean(name, clazz);
    }
}

package com.tysj.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Classname SpringContextUtil
 * @Description TODO
 * @Date 2018/11/13 11:03
 * @Created by xzcawl
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        applicationContext = context;
    }

    public static Object getBean(String id) {
        return applicationContext.getBean(id);
    }

    public static <T> T getBean(Class<T> targetType) {
        return applicationContext.getBean(targetType);
    }

}

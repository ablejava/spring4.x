package com.smart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/4/25.
 */
@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        // 将ConfigurableListableBeanFactory转为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;
        // 创建bean的定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        // 设置bean属性
        beanDefinitionBuilder.addPropertyReference("userDao", "userDao");
        // 注册bean的定义
        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getRawBeanDefinition());
        // 直接注入
        beanFactory.registerSingleton("userService2", new UserService());
    }
}

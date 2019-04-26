package com.smart.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018/7/24.
 */
public class PathMatchingResourcePatternResolverTest {

    public static void main(String[] args) throws IOException {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("log4j.properties");
        // 读取classpath下所有配置文件，包括jar包中的
        // Resource resource = resolver.getResource("classpath*:conf/*.properties");
        InputStream inputStream = resource.getInputStream();
        Properties poolProps = new Properties();
        poolProps.load(inputStream);
        String property = poolProps.getProperty("log4j.rootLogger");
        System.out.println(property);

    }
}

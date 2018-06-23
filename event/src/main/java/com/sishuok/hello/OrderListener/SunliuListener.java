/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.hello.OrderListener;

import com.sishuok.hello.ContentEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 有序监听器
 */
@Component
public class SunliuListener implements SmartApplicationListener {

    /**
     * 指定要支持的事件类型，只有支持的才调用onApplicationEvent
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(final Class<? extends ApplicationEvent> eventType) {
        return eventType == ContentEvent.class;
    }

    /**
     * 指定支持的目标类型，只有支持的目标类型才调用onApplicationEvent
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(final Class<?> sourceType) {
        return sourceType == String.class;
    }

    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        System.out.println("孙六在王五之后收到新的内容：" + event.getSource());
    }

    /**
     * 指定事件调用的顺序，顺序越小调用级别越高
     * @return
     */
    @Override
    public int getOrder() {
        return 2;
    }
}

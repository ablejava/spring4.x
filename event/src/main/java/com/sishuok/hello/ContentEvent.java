/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * http://jinnianshilongnian.iteye.com/blog/1902886
 */
package com.sishuok.hello;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件源
 */
public class ContentEvent extends ApplicationEvent {
    /**
     * 发送的内容通过构造函数传入，然后通过getSource()获取
     * @param content
     */
    public ContentEvent(final String content) {
        super(content);
    }
}

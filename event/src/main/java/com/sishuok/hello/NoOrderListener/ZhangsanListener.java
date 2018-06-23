/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.hello.NoOrderListener;

import com.sishuok.hello.ContentEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ZhangsanListener implements ApplicationListener<ContentEvent> {

    @Override
    public void onApplicationEvent(final ContentEvent event) {
        System.out.println("张三收到了新的内容：" + event.getSource());
    }
}

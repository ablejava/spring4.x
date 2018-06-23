/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(String username, String password) {
        System.out.println(username + "注册成功！");
        publishRegisterEvent(new User(username, password));
        System.out.println("注册主线程执行完成！");
    }

    private void publishRegisterEvent(User user) {
        applicationContext.publishEvent(new RegisterEvent(user));
    }


}

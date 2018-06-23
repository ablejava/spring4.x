/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.register;

import org.springframework.context.ApplicationEvent;

public class RegisterEvent extends ApplicationEvent {

    public RegisterEvent(User user) {
        super(user);
    }

}

package com.sishuok.hello.NoOrderListener;

import com.sishuok.hello.ContentEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/23.
 */
@Component
public class XiaoMingListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContentEvent) {
            System.out.println("小明收到了新内容："+applicationEvent.getSource());
        }
    }
}

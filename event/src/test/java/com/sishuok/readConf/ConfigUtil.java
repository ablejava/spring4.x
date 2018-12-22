package com.sishuok.readConf;

import java.util.ResourceBundle;

public class ConfigUtil {

    // 读取classpath 下config.property 文件
    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    /**
     * 根据key找对应的value
     * @param key
     * @return
     */
    public static final String getProp(String key) {
        return bundle.getString(key);
    }

}

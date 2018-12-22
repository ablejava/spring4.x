package com.sishuok.requestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class ReadRequest {
    /**
     * 读取request域中的json值
     * @param args
     */
    public static void main(String[] args) {
        try {
            HttpServletRequest request = null;
            InputStream inputStream = request.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new  byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0 , len);

            }
            String string = new String(outputStream.toByteArray(), "utf-8");
            JSONObject jsonObject = JSON.parseObject(string);
        } catch (Exception e){
        }
    }
}

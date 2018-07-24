package com.smart.resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/7/24.
 */
public class ByteArrayResourceTest {

    public static void main(String[] args) {
        // 1.ByteArrayResource
        Resource byteArrayResource = new ByteArrayResource("hello world".getBytes());

        // 2.InputStreamResource
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("java".getBytes());
        Resource inputStreamResource = new InputStreamResource(byteArrayInputStream);

        // 3.ClassPathResource 代表classpath路径的资源，将使用ClassLoader进行加载资源。classpath 资源存在于类路径中的文件系统中或jar包里，且“isOpen”永远返回false，表示可多次读取资源。

        // 4.UrlResource http：通过标准的http协议访问web资源，如new UrlResource(“http://地址”)；ftp：通过ftp协议访问资源，如new UrlResource(“ftp://地址”)；file：通过file协议访问本地文件系统资源

        // 5.ServletContextResource 代表web应用资源，用于简化servlet容器的ServletContext接口的getResource操作和getResourceAsStream操作
        if (inputStreamResource.exists()) {
            dumpStream(inputStreamResource);
        }
    }

    private static void dumpStream(Resource inputStreamResource) {
        InputStream inputStream = null;
        try {
            // 1.获取文件资源
            inputStream = inputStreamResource.getInputStream();
            // 2.读取资源
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 3.关闭资源
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }
}

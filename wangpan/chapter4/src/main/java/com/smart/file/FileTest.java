package com.smart.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Administrator on 2018/7/27.
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("D:\\");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s.endsWith(".doc"));
        }

        // 获取D盘下的所有文件路径
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                System.out.println(file1.getAbsolutePath());
            } else {
                System.out.println(file1.getName());
            }
        }



        // **********************************
        /**
         * 过滤符合要求的文件，如果return是true 放到数组中
         */
        String[] list1 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile() && file.getName().endsWith(".doc");
            }
        });
        for (String s : list1) {
            System.out.println(s);
        }
    }
}

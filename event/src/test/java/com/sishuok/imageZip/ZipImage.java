package com.sishuok.imageZip;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipImage {

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zipOps = new ZipOutputStream(baos);
        try {
            List<String> imageBase64 = new ArrayList<String>();
            for (String imageString : imageBase64) {
                try {

                    byte[] bs =  new Base64().decodeBase64(imageString);
                    zipOps.putNextEntry(new ZipEntry(UUID.randomUUID()+""));
                    zipOps.write(bs);
                    zipOps.finish();
                    zipOps.closeEntry();
                } catch (Exception e) {

                }
            }
            byte[] bytes = baos.toByteArray();
            // 上传ftp
        }catch (Exception e){

        }
    }
}

package com.sishuok.requestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public class WriteResponse {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        try {
            String jsonObject = null;
            HttpServletResponse response = null;
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            outputStream = response.getOutputStream();
            outputStream.write(jsonObject.getBytes("utf-8"));
            outputStream.flush();
        } catch (Exception e){


        } finally {
           if (outputStream != null) {
               try {
                  outputStream.close();
               } catch (Exception e){

               }

           }

        }
    }
}

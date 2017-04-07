package com.helper.models;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-04-07.
 */
@Component
public class SpatMain {
    private URL url = null;
    @Autowired
    private UserInfo userinfo;

    public SpatMain(){
        try {
            this.url = new URL("http://www.gzjponline.com/Jp/GetSchedule?start=1490457600&end=1494086400");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    //下载图片的主方法
    public void getPicture() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String path = request.getSession().getServletContext().getRealPath("/")+"/imgs/";

        URL url = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //构建图片的url地址
            url = new URL("http://www.gzjponline.com/member/VerificationImageBooking/?rnd=1491560355603");
            //开启连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时的时间，5000毫秒即5秒
            conn.setConnectTimeout(5000);
            //设置获取图片的方式为GET
            conn.setRequestMethod("GET");
            //响应码为200，则访问成功
            if (conn.getResponseCode() == 200) {
                //获取连接的输入流，这个输入流就是图片的输入流
                is = conn.getInputStream();
                //构建一个file对象用于存储图片
                File file = new File(path,"pic.jpg");
                fos = new FileOutputStream(file);
                int len = 0;
                byte[] buffer = new byte[1024];
                //将输入流写入到我们定义好的文件中
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                //将缓冲刷入文件
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //在最后，将各种流关闭
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String loadFormUrl(){
        String sResult = "";
        userinfo.setName("易舜");
        userinfo.setIdCard("43062419880814637X");
        userinfo.setPhone("13246415560");
        try{
            URLConnection URLconnection = url.openConnection();

            HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;;
            httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.err.println("成功");
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                StringBuilder stringBuilder = new StringBuilder("");
                while ((str = bufr.readLine()) != null) {
                    stringBuilder.append(str);
                }
                sResult = stringBuilder.toString();
                bufr.close();
            } else {
                System.err.println("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            sResult = new String(sResult.getBytes("UTF-8"));
        }catch (Exception e){

        }
        return sResult;
    }
}

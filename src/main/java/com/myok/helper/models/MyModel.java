package com.myok.helper.models;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017-04-07.
 */
@Component
public class MyModel {

    private final OkHttpClient client = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookieStore.put(httpUrl, cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    List<Cookie> cookies = cookieStore.get(url.host());
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })
            .build();
    private HttpUrl httpUrl = new HttpUrl.Builder()
            .scheme("http")
            .host("www.gzjponline.com")
            .addEncodedPathSegments("member/VerificationImageBooking")
            .addQueryParameter("rnd", "1491560355603")
            .build();;

    private URL url = null;
    @Autowired
    private MyUserInfo userinfo;

    public MyModel(){
        try {
            this.url = new URL("http://www.gzjponline.com/Jp/GetSchedule?start=1490457600&end=1494086400");
            System.out.println(httpUrl);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    //下载图片的主方法
    public void getPicture() {
        HttpServletRequest r = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String path = r.getSession().getServletContext().getRealPath("/")+"/imgs/";
        String sResult = "";
        final Request request = new Request.Builder().url(this.httpUrl).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()) {
            try {
                throw new IOException("Unexpected code " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            InputStream is= response.body().byteStream();
            FileOutputStream fos;
            //构建一个file对象用于存储图片
            File file = new File(path,"pic.jpg");
            if(!file.exists())
                file.createNewFile();
            fos = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[1024];
            //将输入流写入到我们定义好的文件中
           try {
               while ((len = is.read(buffer)) != -1) {
                   fos.write(buffer, 0, len);
               }
               //将缓冲刷入文件
               fos.flush();
           }finally {
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
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

    public String loadFormUrl(){
        String sResult = "";
        final Request request = new Request.Builder().url(this.url).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful())
            try {
                throw new IOException("Unexpected code " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            sResult = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sResult;
    }


    public static void main(String[] args) {

       // System.out.println("s:"+s);
       /* Gson gson = new Gson();
        ArrayList<ClassesInfo> classesInfoArrayList = new ArrayList<>();
        Type type = new TypeToken<ArrayList<ClassesInfo>>() {}.getType();

        classesInfoArrayList=gson.fromJson(s, type);
        System.out.println("info:");
        System.out.println(classesInfoArrayList.toString());*/

    }

    public OkHttpClient getClient() {
        return client;
    }
}

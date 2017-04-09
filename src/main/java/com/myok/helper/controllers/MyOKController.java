package com.myok.helper.controllers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.helper.models.SpatMain;
import com.myok.helper.models.ClassesInfo;
import com.myok.helper.models.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-04-07.
 */
@Controller
public class MyOKController {
    @Autowired
    private MyModel spatMain;
    @ResponseBody
    @RequestMapping(value = "/getJ", method = RequestMethod.GET)
    public String getJson(){
        String s;
        s = spatMain.loadFormUrl();
        Gson gson = new Gson();
        ArrayList<ClassesInfo> classesInfoArrayList = new ArrayList<>();
        Type type = new TypeToken<ArrayList<ClassesInfo>>() {}.getType();

        classesInfoArrayList=gson.fromJson(s, type);
        return s;
    }
    @ResponseBody
    @RequestMapping(value = "/getP", method = RequestMethod.GET)
    public String getPic(){
        String s=null;
        spatMain.getPicture();
       // spatMain.
        return s;
    }
}

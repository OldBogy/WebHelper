package com.helper.controller;
import com.helper.models.SpatMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-04-07.
 */
@Controller
public class GetJsonController {
    @Autowired
    private SpatMain spatMain;
    @ResponseBody
    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    public String getJson(){
        String s;
        s = spatMain.loadFormUrl();
        return s;
    }
    @ResponseBody
    @RequestMapping(value = "/getPic", method = RequestMethod.GET)
    public String getPic(){
        String s=null;
        spatMain.getPicture();
        return s;
    }
}

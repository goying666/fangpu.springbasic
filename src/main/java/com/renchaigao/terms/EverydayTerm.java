package com.renchaigao.terms;

import com.renchaigao.mybatisInit;
import com.renchaigao.terms.func.termFunc;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/terms")
public class EverydayTerm {


    @RequestMapping(value = "/funa" , method = RequestMethod.POST ,consumes = "application/json")
    @ResponseBody
    public String returnEverdayTerms(@RequestBody Date todayDate){
        String ret = null;
        System.out.println("todayDate is " + todayDate);
        ret = termFunc.returnEverdayTermsTermFunc(todayDate);
        System.out.println("ret is " + ret);
        return ret;
//        System.out.println("reciveBodyTest is " + userlogin.getName());
//        return userlogin;
    }
    @RequestMapping(value = "/funb" , method = RequestMethod.POST ,consumes = "application/json")
    @ResponseBody
    public String testforwx(@RequestBody Date todayDate){
//        JSONObject ret = {"a":"b"};
        //定义JSON字符串
        String jsonStr =  "{ \"id\": 2," + " \"title\": \"json title\" }" ;

        //转换成为JSONObject对象
        JSONObject jsonObj = new JSONObject(jsonStr);
        System.out.println("jsonStr is :  " + "{ \"id\": 2," + " \"title\": \"json title\" }" );
        System.out.println("jsonObj is :  " + jsonObj.get("id"));

//        ret = jsonIn.get("jsonTest21").toString();
        return jsonStr;
//        System.out.println("reciveBodyTest is " + userlogin.getId());
//        System.out.println("reciveBodyTest is " + userlogin.getName());
//        return userlogin;
    }



}

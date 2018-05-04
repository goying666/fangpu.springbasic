package com.renchaigao.terms.func;

import com.alibaba.fastjson.JSON;
import com.renchaigao.merge.merge;
import com.renchaigao.mybatisInit;
import com.renchaigao.terms.everdayTerms;
import com.renchaigao.terms.termMapper;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public class termFunc {

    public static String returnEverdayTermsTermFunc(Date todayDate){
        String ret = null;
        mybatisInit batisinit = new mybatisInit();
        SqlSession sqlSession = batisinit.getSessionFactory().openSession();
        termMapper usmapper = sqlSession.getMapper(termMapper.class);
        List<everdayTerms> listEverdayTerms ;
        try{
           listEverdayTerms = usmapper.getEverdayTermByDate(merge.dateToString(todayDate));
            ret = JSON.toJSONString(listEverdayTerms,true);
        }catch (Exception e){
            System.out.println( "returnEverdayTerms : " + e);
        }
        return ret;
    }

}

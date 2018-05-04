package com.renchaigao.answer.func;

import com.renchaigao.answer.answerMapper;
import com.renchaigao.answer.oneAnswer;
import com.renchaigao.merge.merge;
import com.renchaigao.mybatisInit;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class answerFunc {

//    用户添加回复信息至数据库
    public String userAddAnswerInfo(oneAnswer oneAnswer){
        String ret = null;
        try {
            mybatisInit batisinit = new mybatisInit();
            System.out.println("*************begin**************");
            SqlSession sqlSession = batisinit.getSessionFactory().openSession();
            answerMapper answermapper = sqlSession.getMapper(answerMapper.class);
            answermapper.addOneAnswer(oneAnswer);
            sqlSession.commit();
            ret = "finish";
        }catch (Exception e){
            System.out.println("answerFunc.userAddAnswerInfo is : ");
            ret = "wrong";
        }
        return  ret;
    }

    public String userAddAnserRecoding(MultipartFile file ,String filePathOnService) throws FileNotFoundException {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream(
                                        new File(filePathOnService +file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    public String userGetRecodingFilePath(Integer recodingId , Integer userId)
    {
        mybatisInit batisinit = new mybatisInit();
        System.out.println("*************begin**************");
        SqlSession sqlSession = batisinit.getSessionFactory().openSession();
        answerMapper answermapper = sqlSession.getMapper(answerMapper.class);
    }
}

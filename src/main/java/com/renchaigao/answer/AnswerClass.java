package com.renchaigao.answer;

import com.alibaba.fastjson.JSON;
import com.renchaigao.answer.func.answerFunc;
import com.renchaigao.terms.func.termFunc;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/answer")
public class AnswerClass {

    @RequestMapping(value = "/addanswerinfo" , method = RequestMethod.POST ,consumes = "application/json")
    @ResponseBody
    public String userAddAnswerInfo(@RequestBody oneAnswer oneAnswer){
        answerFunc funcUse = new answerFunc();
        return funcUse.userAddAnswerInfo(oneAnswer);
    }

    @RequestMapping(value = "/addanswerrecording" , method = RequestMethod.POST ,consumes = "multipart/form-data")
    @ResponseBody
    public String userAddRecordingFile(@RequestParam("file999") MultipartFile file) throws FileNotFoundException {
        answerFunc funcUse = new answerFunc();
        return  funcUse.userAddAnserRecoding(file，);
    }

    @RequestMapping(value = "/getoneanswer" , method = RequestMethod.GET ,produces = "multipart/form-data")
    @ResponseBody
    public FileInputStream getoneanswer(@RequestParam String filePath) throws FileNotFoundException {
        FileInputStream files = new FileInputStream(filePath);

        System.out.println("filePath is : "+filePath );
        return files;
    }




//        if (!file.isEmpty()) {
//            try {
//                /*
//                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
//                 * d:/files大家是否能实现呢？ 等等;
//                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
//                 * 3、文件格式; 4、文件大小的限制;
//                 */
//                BufferedOutputStream out =
//                        new BufferedOutputStream(
//                                new FileOutputStream(
//                                        new File(file.getOriginalFilename())));
//                InputStream inputStream = file.getInputStream();
//                System.out.println(file.getName());
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "上传失败," + e.getMessage();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "上传失败," + e.getMessage();
//            }
//
//            return "上传成功";
//
//        } else {
//            return "上传失败，因为文件是空的.";
//        }
//    }
}

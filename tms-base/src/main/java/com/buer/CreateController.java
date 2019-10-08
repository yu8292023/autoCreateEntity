package com.buer;

import com.buer.CodeGenerator;
import com.buer.config.Catalogautocreate;
import jdk.nashorn.internal.runtime.options.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Description:
 * @ClassName:controller
 * @Author:yuhaining
 * @Date:2019/10/1 0001
 */

@RestController
public class CreateController {

    private static Logger logger = LoggerFactory.getLogger(CreateController.class);

//    @Value("${logging.file}")
    String logFilename;

    @RequestMapping("query")
    public Object aC(){
        HashMap ret = new HashMap();
        ret.put("windowUrl", Catalogautocreate.windowUrl);
        ret.put("PACKAGENAME", Catalogautocreate.PACKAGENAME);
        ret.put("TABLENAMES", Catalogautocreate.TABLENAMES);
        ret.put("AUTHOR", Catalogautocreate.AUTHOR);
        return ret;
    }

    @RequestMapping("exec")
    public Object aC1(@RequestBody Map map) {
        File file = new File(System.getProperty("user.dir") +"//"+ logFilename);
        this.clearFile(file);
        try {
            this.setThatValue(map);
            CodeGenerator.execute();
        }catch (Exception e){
            logger.error("异常信息:",e.fillInStackTrace());
        }

        StringBuffer sb = this.readFile(file);
        HashMap ret = new HashMap();
        ret.put("MESSAGE", sb.toString());
        return ret;
    }

    private void setThatValue(Map map){
            if(map != null){
                String windowUrl = map.get("windowUrl")==null? "" : map.get("windowUrl").toString();
                String PACKAGENAME = map.get("PACKAGENAME")==null? "" : map.get("PACKAGENAME").toString();
                String TABLENAMES = map.get("TABLENAMES")==null? "" : map.get("TABLENAMES").toString();
                String AUTHOR = map.get("AUTHOR")==null? "" : map.get("AUTHOR").toString();
                Catalogautocreate.windowUrl = windowUrl;
                Catalogautocreate.PACKAGENAME = PACKAGENAME;
                Catalogautocreate.TABLENAMES = TABLENAMES;
                Catalogautocreate.AUTHOR = AUTHOR;
            }
    }

    private void clearFile(File file){
        try {
            if(!file.exists()) {
                return;
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private StringBuffer readFile(File file){
        Reader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                sb.append((char)tempchar);
            }
            reader.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return sb;
    }


}

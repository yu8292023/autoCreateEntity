package com.buer.config;

import com.buer.autoRun.CodeGenerator;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description:
 * @ClassName:Catalogautocreate
 * @Author:yuhaining
 * @Date:2019/9/30 0030
 */
public class Catalogautocreate {
    public static String FENGE = "\\";
    public static String JIANGEHAO = ".";

    public static String BASEPATH = System.getProperty("user.dir") + Catalogautocreate.FENGE+ "tms-base";

    public static String windowUrl = BASEPATH + Catalogautocreate.FENGE+ "src" + Catalogautocreate.FENGE+ "main" + Catalogautocreate.FENGE+ "java";

    public static String PACKAGENAME = "com.huaxincem.tms";
    //模块名
    public static String MK = "";
    // 表名称
    public static String TABLENAMES = "tms_sys_user";
    // 作者
    public static String AUTHOR = "yuhaining";

    //数据库信息
    public static  String DATASOURCEURL = "jdbc:mysql://10.248.61.27:3306/tms_test?useUnicode=true&characterEncoding=gbk&serverTimezone=UTC";
    public static  String DATASOURCEDRIVER = "com.mysql.cj.jdbc.Driver";
    public static  String DATASOURCEUSERNAME = "temp";
    public static  String DATASOURCEPASSWORD = "Temp!2019";
}

package com.buer.config;

import com.buer.CodeGenerator;

/**
 * @Description:
 * @ClassName:Catalogautocreate
 * @Author:yuhaining
 * @Date:2019/9/30 0030
 */
public class Catalogautocreate {
    public static String FENGE = "\\";

    public static String BASEPATH = System.getProperty("user.dir") + Catalogautocreate.FENGE+"tms-base";
    public static String windowUrl = BASEPATH + Catalogautocreate.FENGE+ "src"
            + Catalogautocreate.FENGE+ "main" + Catalogautocreate.FENGE+ "java";

    public static String PACKAGENAME = CodeGenerator.class.getPackage().getName();
    //模块名
    public static String MK = "";
    // 表名称
    public static String TABLENAMES = "表名(多个用,隔开)";
    // 作者
    public static String AUTHOR = "于海宁";
}

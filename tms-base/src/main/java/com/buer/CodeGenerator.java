package com.buer;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @ClassName:CodeGenerator
 * @Author:yuhaining
 * @Date:2019/9/28 0028
 */
public class CodeGenerator {

    public static String ROOT_PATH = "W:\\autoCrete";
    public static String PAKAGE = "/tms/";
    //模块名
    public static String MUNAME = "";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        // 数据源配置
        mpg.setDataSource(getDb());
        //包名信息
        mpg.setPackageInfo(getPackageConfig());
        // 自定义配置
        mpg.setCfg(getInjectionConfig());
        // 配置模板
        mpg.setTemplate(getTemplateConfig());
        // 策略配置
        mpg.setStrategy(getStrategyConfig());

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    // 数据源配置
    private static DataSourceConfig getDb(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://10.248.61.27:3306/tms_dev?useUnicode=true&characterEncoding=gbk&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("temp");
        dsc.setPassword("Temp!2019");
        return dsc;
    }
    // 全局配置
    private static GlobalConfig getGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setOutputDir(ROOT_PATH);//文件输出目录
        gc.setAuthor("yuhaining");
        gc.setOpen(true);//自动打开
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setActiveRecord(true);//开启activeRecord
        return gc;
    }
    //包名信息
    private static PackageConfig getPackageConfig(){
        PackageConfig pc = new PackageConfig();
        MUNAME = scanner("模块名");
        pc.setModuleName(MUNAME);
        pc.setParent("com.huaxin.cloud.tms.base");
        return pc;
    }


    // 策略配置
    public static StrategyConfig getStrategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNameConvert(null);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("tms" + "_");
        //自定义父类
//        strategy.setSuperEntityClass();
        return strategy;
    }

    // 策略配置
    public static TemplateConfig getTemplateConfig(){
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(PAKAGE+"controller.java");
        templateConfig.setService(PAKAGE+"service.java");
        templateConfig.setServiceImpl(PAKAGE+"serviceImpl.java");
        templateConfig.setEntity(PAKAGE+"entity.java");
        templateConfig.setEntityKt(PAKAGE+"entity.kt");
        templateConfig.setMapper(PAKAGE+"mapper.java");
//        templateConfig.setXml(p+"mapper.xml");
        return templateConfig;
    }

    // 自定义配置
    public static InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = PAKAGE + "mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return ROOT_PATH + "/src/main/resources/mappers/" + MUNAME
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        return cfg;
    }
}

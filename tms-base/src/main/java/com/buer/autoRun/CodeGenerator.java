package com.buer.autoRun;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.buer.config.Catalogautocreate;
import com.buer.config.JframeWindow;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName:CodeGenerator
 * @Author:yuhaining
 * @Date:2019/9/28 0028
 */
public class CodeGenerator {

    //模板路径
    private String PAKAGE = "/tms/";


    public void execute(){
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


    // 全局配置
    private GlobalConfig getGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("%sEntity");
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setOutputDir(Catalogautocreate.windowUrl);//文件输出目录
        gc.setAuthor(Catalogautocreate.AUTHOR);
        gc.setOpen(true);//自动打开
        gc.setSwagger2(true);// 实体属性 Swagger2 注解
        gc.setActiveRecord(false);//开启activeRecord
        return gc;
    }
    //包名信息
    private PackageConfig getPackageConfig(){
        PackageConfig pc = new PackageConfig();
        if(!StringUtils.isEmpty(Catalogautocreate.MK)){
            pc.setModuleName(Catalogautocreate.MK);
        }
        pc.setMapper("dao");
        pc.setParent(Catalogautocreate.PACKAGENAME);
        return pc;
    }


    // 策略配置
    public StrategyConfig getStrategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNameConvert(null);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setInclude(Catalogautocreate.TABLENAMES.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);
        strategy.setTablePrefix("tms" + "_");
        //自定义父类
//        strategy.setSuperEntityClass();
        return strategy;
    }

    // 策略配置
    public TemplateConfig getTemplateConfig(){
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setController(PAKAGE+"controller.java");
        templateConfig.setService(PAKAGE+"service.java");
        templateConfig.setServiceImpl(PAKAGE+"serviceImpl.java");
        templateConfig.setEntity(PAKAGE+"entity.java");
        templateConfig.setEntityKt(PAKAGE+"entity.kt");
        templateConfig.setMapper(PAKAGE+"mapper.java");
        templateConfig.setXml(""/*PAKAGE+"mapper.xml"*/);
        return templateConfig;
    }

    // 自定义配置
    public InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map dtoMap = new HashMap<>();
                dtoMap.put("package.reqDTO",  Catalogautocreate.PACKAGENAME + ".dto.Request");
                dtoMap.put("package.resDTO", Catalogautocreate.PACKAGENAME + ".dto.Response");
                this.setMap(dtoMap);
            }
        };

        String templatePath = PAKAGE + "mapper.xml.ftl";
        String templatePathReqDTO = PAKAGE + "reqDTO.java.ftl";
        String templatePathResDTO = PAKAGE + "resDTO.java.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义xml模板
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return Catalogautocreate.BASEPATH.replace("\\","/") + "/src/main/resources/mappers/" + Catalogautocreate.MK
                         + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        // 自定义reqDTO模板
        focList.add(new FileOutConfig(templatePathReqDTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return Catalogautocreate.windowUrl +"/"+ Catalogautocreate.PACKAGENAME.replace(".", "/") +"/"+ Catalogautocreate.MK
                        + "/dto/Request/Req" +tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        // 自定义resDTO模板
        focList.add(new FileOutConfig(templatePathResDTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return Catalogautocreate.windowUrl +"/"+ Catalogautocreate.PACKAGENAME.replace(".", "/") +"/"+ Catalogautocreate.MK
                        + "/dto/Response/Res" +tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    // 数据源配置
    private DataSourceConfig getDb(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(Catalogautocreate.DATASOURCEURL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(Catalogautocreate.DATASOURCEDRIVER);
        dsc.setUsername(Catalogautocreate.DATASOURCEUSERNAME);
        dsc.setPassword(Catalogautocreate.DATASOURCEPASSWORD);
        return dsc;
    }
}

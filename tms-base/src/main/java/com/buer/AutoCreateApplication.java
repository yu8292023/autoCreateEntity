package com.buer;

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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName:CodeGenerator
 * @Author:yuhaining
 * @Date:2019/9/28 0028
 */
@SpringBootApplication
public class AutoCreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoCreateApplication.class, args);
    }


}

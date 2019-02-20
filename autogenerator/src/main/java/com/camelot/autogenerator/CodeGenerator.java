package com.camelot.autogenerator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName CodeGenerator
 * @Description TODO
 * @Author admin
 * @Date 2019/2/20 11:28
 * @Version 1.0
 */
public class CodeGenerator {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip +":");
        System.out.println(help.toString());
        if (scanner.hasNext()){
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" +  tip + "!");
    }

    public static void main(String[] args){
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取用户当前的工作目录 D:\java\workspace\autougenerator
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("lyp");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("lyp66lyp");
        mpg.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("模块名"));  可以不写
        //父包名
        pc.setParent("com.camelot.autogenerator");
        pc.setEntity("domain");
        /*包名配置，通过该配置，指定生成代码的包路径*/
        mpg.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };

        //模板引擎  freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件名
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //继承BaseDomain 可写可不写   写：需要创建BaseDomain
        strategy.setSuperEntityClass("com.camelot.autogenerator.common.domain");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //继承BaseController 可写可不写   写：需要创建BaseController
        strategy.setSuperControllerClass("com.camelot.autogenerator.common.controller");
        strategy.setInclude(scanner("表名"));
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}

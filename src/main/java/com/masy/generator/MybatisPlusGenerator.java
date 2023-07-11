package com.masy.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author masy
 * @date 2022/6/7 12:08
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator ag = new AutoGenerator();
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        //设置作者
        gc.setAuthor("masy");
        //是否打开输出目录
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        //实体命名方式
        gc.setEntityName("%s");
        //Mapper命名方式
        gc.setMapperName("%sMapper");
        //xml 命名方式
        gc.setXmlName("%sMapper");
        //时间类型对应策略
        gc.setDateType(DateType.ONLY_DATE);
        ag.setGlobalConfig(gc);

        //数据源设置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/xq-ssg-new?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowPublicKeyRetrieval=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("12345678");
        ag.setDataSource(dsc);

        //包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.masy.generator.model");
        //---------------------模块名（按需修改）--------------------------------------------
//        pc.setModuleName("ipad");
        pc.setEntity("entity");
        //Mapper 包名
        pc.setMapper("dao");
        // xml 包名
        pc.setXml("dao.mapper");
        ag.setPackageInfo(pc);

        //策略配置
        StrategyConfig sc = new StrategyConfig();
        //表名前缀
        sc.setTablePrefix("system_");
        //表名生成策略
        sc.setNaming(NamingStrategy.underline_to_camel);
        //---------------------表名（按需修改）--------------------------------------------
        sc.setInclude("system_users");
        //实体是否生成字段常量（默认 false）
        sc.setEntityColumnConstant(false);
        //实体是否为lombok模型（默认 false）
        sc.setEntityLombokModel(true);
        //Boolean类型字段是否移除is前缀（默认 false）
//        sc.setEntityBooleanColumnRemoveIsPrefix(true);
        // 是否生成实体时，生成字段注解
        sc.entityTableFieldAnnotationEnable(true);
        // 自定义需要填充的字段 数据库中的字段
//        List<TableFill> tableFillList = new ArrayList<>();
//        tableFillList.add(new TableFill("create_date", FieldFill.INSERT));
//        tableFillList.add(new TableFill("create_id", FieldFill.INSERT));
//        tableFillList.add(new TableFill("update_id", FieldFill.INSERT_UPDATE));
//        tableFillList.add(new TableFill("update_date", FieldFill.INSERT_UPDATE));
        // 表填充字段
//        sc.setTableFillList(tableFillList);
        ag.setStrategy(sc);

        ag.execute();
    }
}

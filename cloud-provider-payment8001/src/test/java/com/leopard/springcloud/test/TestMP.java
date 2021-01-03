package com.leopard.springcloud.test;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Scanner;

/**
 * @author leo-zu
 * @create 2020-10-18 17:54
 */
public class TestMP {

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
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 代码生成，示例代码
     */
//    @Test
//    public void testGennerator(){
//
//        /**
//         * 1. 全局配置
//         */
//
//        GlobalConfig globalConfig = new GlobalConfig();
//        // 生成路径
//        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
//        // 作者
//        globalConfig.setAuthor("leo-zu");
//        // 是否支持AR模式
//        globalConfig.setActiveRecord(true);
//        // 文件覆盖
//        globalConfig.setFileOverride(true);
//        // 主键策略,自增
//        globalConfig.setIdType(IdType.AUTO);
//        // 设置生成的service接口的名字的首字母是否为I
//        globalConfig.setServiceName("%sService");
//        // 设置基本的映射
//        globalConfig.setBaseResultMap(true);
//        // 设置基本列集合
//        globalConfig.setBaseColumnList(true);
//        globalConfig.setOpen(false);
//
//
//        /**
//         * 2. 数据源配置
//         */
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        // 设置数据库类型
//        dataSourceConfig.setDbType(DbType.ORACLE);
//        dataSourceConfig.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
//        dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");
//        dataSourceConfig.setUsername("c##leo");
//        dataSourceConfig.setPassword("54leopard");
//
//
//        /**
//         * 3. 策略配置
//         */
//        StrategyConfig strategyConfig = new StrategyConfig();
//        // 设置全局大写命名
//        strategyConfig.setCapitalMode(true);
//        // 指数据库表映射到实体的命名策略（驼峰）
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        // 数据库字段映射到实体的命名策略
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        // 设置表名前缀
//        strategyConfig.setTablePrefix("tbl_");
//        // 生成的表
//        strategyConfig.setInclude("tbl_payment");
//
//
//        /**
//         * 4. 包名策略配置
//         */
//        PackageConfig packageConfig = new PackageConfig();
////        packageConfig.setModuleName(scanner("模块名"));
//        packageConfig.setParent("com.leopard.springcloud")
//                     .setMapper("mapper")
//                     .setService("service")
//                     .setController("controller")
//                     .setEntity("entity")
//                     .setXml("mapper"); //表示xml文件和mapper放到一个文件夹下
//
//
//        /**
//         * 5. 整合配置
//         */
//        AutoGenerator autoGenerator = new AutoGenerator();
//        autoGenerator.setGlobalConfig(globalConfig);
//        autoGenerator.setDataSource(dataSourceConfig);
//        autoGenerator.setStrategy(strategyConfig);
//        autoGenerator.setPackageInfo(packageConfig);
//
//        /**
//         * 执行
//         */
//        autoGenerator.execute();
//
//    }

    @Test
    public void test1(){
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

}

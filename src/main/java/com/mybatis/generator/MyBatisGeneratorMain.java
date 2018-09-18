package com.mybatis.generator;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-09-18 9:24
 */
public class MyBatisGeneratorMain {

    public static void main(String[] args) {
        try {
            generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        File configFile = new File("./src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        org.mybatis.generator.api.MyBatisGenerator myBatisGenerator = new org.mybatis.generator.api.MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}

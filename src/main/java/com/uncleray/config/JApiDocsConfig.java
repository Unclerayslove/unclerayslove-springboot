package com.uncleray.config;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @program: uncle-springboot
 * @description:
 * @author: lei pei
 * @create: 2020-11-29 10:44
 */
public class JApiDocsConfig {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\Common Files\\Code-Repository\\unclerayslove-springboot"); // 项目根目录
        config.setProjectName("Uncle-Ray"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\Common Files\\Code-Repository"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}

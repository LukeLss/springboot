package com.gree.lss.springbootDruid.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    @Value("${pageHelper.helperDialect}")
    private String helperDialect;

    @Value("${pageHelper.reasonable}")
    private String reasonable;

    @Value("${pageHelper.supportMethodsArguments}")
    private String supportMethodsArguments;

    @Value("${pageHelper.params}")
    private String params;

    @Value("${pageHelper.returnPageInfo}")
    private String returnPageInfo;

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect",helperDialect);
        properties.setProperty("reasonable",reasonable);
        properties.setProperty("supportMethodsArguments",supportMethodsArguments);
        properties.setProperty("params",params);
        properties.setProperty("returnPageInfo",returnPageInfo);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

}

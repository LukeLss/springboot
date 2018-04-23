package com.gree.lss.springbootDruid.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * fastJson配置
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {
    /**
     * 修改自定义消息转换器
     * Configure the {@link HttpMessageConverter}s to use for reading or writing
     * to the body of the request or response. If no converters are added, a
     * default list of converters is registered.
     * <p><strong>Note</strong> that adding converters to the list, turns off
     * default converter registration. To simply add a converter without impacting
     * default registration, consider using the method
     * {@link #extendMessageConverters(List)} instead.
     *
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
                /**
                 * FastJson SerializerFeatures
                 * WriteNullListAsEmpty : List字段如果为null，输出为[]
                 * WriteNullStringAsEmpty:字符串类型字段如果为null，输出""
                 * DisableCirculateReferenceDetect:消除对同一对象循环引用的问题，默认为false，不配置有可能进入死循环
                 * WriteNullBooleanAsFalse:Boolean字段为null时，输出false
                 * WriteMapNullValue:是否输出值为null的字段，默认为false
                 */
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastJson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }
}

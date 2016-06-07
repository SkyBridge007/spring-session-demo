package com.bridge.session.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月28日 下午12:35:10
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 
*/
@Configuration
@ComponentScan(basePackages={"com.bridge.session.service.impl"})
@PropertySource("classpath:config.properties")
public class AppConfig{
	
    @Resource
    private Environment env;
}

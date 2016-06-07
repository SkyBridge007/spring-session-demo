package com.bridge.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月28日 下午12:37:03
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 
*/
@Configuration
@ComponentScan(basePackages={"com.bridge.session.web"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
	}
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}

package com.bridge.session.dispatcher;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bridge.session.config.AppConfig;
import com.bridge.session.config.RedisClusterSessionConfig;
import com.bridge.session.config.WebMvcConfig;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月28日 下午12:33:09
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 
*/
public class AnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.setAsyncSupported(true);
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {AppConfig.class,RedisClusterSessionConfig.class,WebMvcConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {};
	}
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}

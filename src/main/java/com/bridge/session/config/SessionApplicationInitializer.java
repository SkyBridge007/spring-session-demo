package com.bridge.session.config;


import org.springframework.core.annotation.Order;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月23日 上午9:36:35
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 ：主要用于向应用容器添加springSessionRepositoryFilter,顺便注册一下HttpSessionEventPublisher监听,
* 		    这个监听的作用发布HttpSessionCreatedEvent和HttpSessionDestroyedEvent事件
*/
@Order(99)
public class SessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {
   
}
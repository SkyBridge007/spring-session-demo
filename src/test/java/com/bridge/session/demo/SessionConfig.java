package com.bridge.session.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月23日 上午9:34:37
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 :用来启用RedisHttpSession,在这里配置注册一个redis客户端的连接工厂Bean,
* 		  供Spring Session用于与redis服务端交互.
*/
@Configuration
@EnableRedisHttpSession  
public class SessionConfig {
	
	/**
	 * 该实现采用redis单节点,缓存session数据
	 * @return
	 */
    @Bean  
    public JedisConnectionFactory connectionFactory() {  
    	JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("10.16.69.184");
		jedisConnectionFactory.setPort(6377);
		return jedisConnectionFactory; 
    }  
}

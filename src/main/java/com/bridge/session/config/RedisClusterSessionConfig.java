package com.bridge.session.config;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import redis.clients.jedis.JedisPoolConfig;

/** 
* @author 作者 ：Bridge
* @version 版本：1.0
* @createTime 创建时间：2016年5月28日 上午10:16:19
* @E-mail 邮箱：hu.wu@midea.com
* 类说明 :用来启用RedisHttpSession,在这里配置注册一个JedisConnectionFactory客户端的连接工厂Bean,
* 		  供Spring Session用于与redis服务端交互，以集群方式存储session信息.
*/
@Configuration
@EnableRedisHttpSession
public class RedisClusterSessionConfig {

	@Resource
	private Environment env;
	
	@Bean  
    public JedisConnectionFactory jedisConnectionFactory() {
    	
        String[] jedisClusterNodes = env.getProperty("redis.jedisClusterNodes").split(",");  
        RedisClusterConfiguration clusterConfig=new RedisClusterConfiguration(Arrays.asList(jedisClusterNodes));  
        clusterConfig.setMaxRedirects(env.getProperty("redis.maxRedirections",Integer.class));  
  
        JedisPoolConfig poolConfig=new JedisPoolConfig();  
        poolConfig.setMaxWaitMillis(env.getProperty("redis.maxWaitMillis",Integer.class));  
        poolConfig.setMaxTotal(env.getProperty("redis.maxTotal",Integer.class));  
        poolConfig.setMinIdle(env.getProperty("redis.minIdle",Integer.class));  
        poolConfig.setMaxIdle(env.getProperty("redis.maxIdle",Integer.class));  

        return new JedisConnectionFactory(clusterConfig,poolConfig);  
    }
	
	/**
	 * 注入该Bean,即启用HeaderHttpSessionStrategy策略
	 * 即在返回消息的HttpHeader中存在x-auth-token存储服务端的SESSIONID
	 * 浏览器再次请求服务器时在HttpHeader的x-auth-token域中带回服务端返回的SESSIONID
	 * @return
	 */
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
            return new HeaderHttpSessionStrategy(); 
    }
    
    /**
     * 采用默认的cookie 策略时，可以通过该方式指定cookieName,cookiePath等.
     * @return
     */
    /*
	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("JSESSIONID"); // <1>
		serializer.setCookiePath("/"); // <2>
		serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
		return serializer;
	}
	*/

    /**
     * For dealing with high available Redis there is support for Redis Sentinel using RedisSentinelConfiguration.
     * Please note that currently only Jedis and lettuce Lettuce support Redis Sentinel.
     */
    
	/**
	 * jedis
	 */
    /*
	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
	  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() .master("mymaster")
	  .sentinel("127.0.0.1", 26379) .sentinel("127.0.0.1", 26380);
	  return new JedisConnectionFactory(sentinelConfig);
	}
	*/
	/**
	 * lettuce
	 */
	/*
	@Bean
	public RedisConnectionFactory lettuceConnectionFactory() {
	  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
	  .sentinel("127.0.0.1", 26379) .sentinel("127.0.0.1", 26380);
	  return new LettuceConnectionFactory(sentinelConfig);
	}
*/

    /*
	RedisSentinelConfiguration can also be defined via PropertySource.
	Configuration Properties
	
	    spring.redis.sentinel.master: name of the master node.
	
	    spring.redis.sentinel.nodes: Comma delimited list of host:port pairs.
	*/    

    

}

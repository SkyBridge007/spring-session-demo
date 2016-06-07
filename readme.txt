本工程是基于spring-session和redis cluster 集成的样例工程。
采用集中session存储于redis cluster,已解决分布式应用的回话共享和数据共享的问题。

该会话保持策略有两种形式：
1、spring session 默认采用cookie 的方式
	Cookie
		SESSION:xxxxx
		域：localhost
		路径：/spring-session-demo/
		过期时间:浏览会话结束时


2、采用在HttpHeader中添加x-auth-token
	首次请求后端，会在相应的response header中带回x-auth-token域，前端JS获取该值后可存于浏览器cookie中，
	以备下次请求后端时，在request header的x-auth-token域中带上该值，即可与上次请求保持在同一回话中。
	工程目录H5文件夹下是配合该方案的前端JS代码.





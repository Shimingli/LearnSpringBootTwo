## Spring Boot中开启Spring Security  

* Spring Security是一款基于Spring的安全框架，主要包含认证和授权两大安全模块，和另外一款流行的安全框架Apache Shiro相比，它拥有更为强大的功能。Spring Security也可以轻松的自定义扩展以满足各种需求，并且对常见的Web安全攻击提供了防护支持。如果你的Web框架选择的是Spring，那么在安全方面Spring Security会是一个不错的选择。
  
  这里我们使用Spring Boot来集成Spring Security，Spring Boot版本为1.5.14.RELEASE，Spring Security版本为4.2.7RELEASE。
  
  
  * 通过控制台 log日志 去寻找开启的密码和用户名，漠然的用户名是 user
  
  * 默认的用户名为user，密码由Sping Security自动生成，回到IDE的控制台
  
```  
2018-09-30 09:00:10.436  INFO 4384 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-30 09:00:10.531  INFO 4384 --- [           main] b.a.s.AuthenticationManagerConfiguration : 

Using default security password: 2f7a1295-4d21-4da7-87ee-2735151ec16f


```  

* 以下的开启的方式就是通过，登录路由器的密码的页面，在浏览器上弹窗 
```  

         http.httpBasic() // HTTP Basic
                .and()
                .authorizeRequests() // 授权配置
                .anyRequest()  // 所有请求
                .authenticated(); // 都需要认证

```


* 。上面配置指定了认证方式为表单登录，并且所有请求都需要进行认证。这时候我们重启项目，再次访问http://localhost:8080/hello，可以看到认证方式已经是form表单的方式了：

```  
        http.formLogin() // 表单登录
//         http.httpBasic() // HTTP Basic
                .and()
                .authorizeRequests() // 授权配置
                .anyRequest()  // 所有请求
                .authenticated(); // 都需要认证

```
## 发送Email 

```  
server:
  port: 80

spring:
  mail:
    host: smtp.163.com
    username: lamshiming@163.com
    password: lishiming687366
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
            required: true

```

*  注意是授权码,不是我的验证码啊
*  password: qazwsx123456

![Image 解释](使用spring%20boot%20发送邮件.png)



* 引入依赖
  在Spring Boot中发送邮件，需要用到spring-boot-starter-mail，引入spring-boot-starter-mail：
  
```  
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>

```

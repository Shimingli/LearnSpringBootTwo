##  Spring Boot中使用thymeleaf

* Thymeleaf Thymeleaf 的基本语法 Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。 

* Spring Boot支持FreeMarker、Groovy、Thymeleaf和Mustache四种模板解析引擎，官方推荐使用Thymeleaf。

spring-boot-starter-thymeleaf
在Spring Boot中使用Thymeleaf只需在pom中加入Thymeleaf的starter即可：
```

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

```


* 在Spring Boot中，默认的html页面地址为src/main/resources/templates，默认的静态资源地址为src/main/resources/static。



* Thymeleaf默认配置
  在Spring Boot配置文件中可对Thymeleaf的默认配置进行修改：
  
``` 

#开启模板缓存（默认值：true）
spring.thymeleaf.cache=true 
#Check that the template exists before rendering it.
spring.thymeleaf.check-template=true 
#检查模板位置是否正确（默认值:true）
spring.thymeleaf.check-template-location=true
#Content-Type的值（默认值：text/html）
spring.thymeleaf.content-type=text/html
#开启MVC Thymeleaf视图解析（默认值：true）
spring.thymeleaf.enabled=true
#模板编码
spring.thymeleaf.encoding=UTF-8
#要被排除在解析之外的视图名称列表，用逗号分隔
spring.thymeleaf.excluded-view-names=
#要运用于模板之上的模板模式。另见StandardTemplate-ModeHandlers(默认值：HTML5)
spring.thymeleaf.mode=HTML5
#在构建URL时添加到视图名称前的前缀（默认值：classpath:/templates/）
spring.thymeleaf.prefix=classpath:/templates/
#在构建URL时添加到视图名称后的后缀（默认值：.html）
spring.thymeleaf.suffix=.html
#Thymeleaf模板解析器在解析器链中的顺序。默认情况下，它排第一位。顺序从1开始，只有在定义了额外的TemplateResolver Bean时才需要设置这个属性。
spring.thymeleaf.template-resolver-order=
#可解析的视图名称列表，用逗号分隔
spring.thymeleaf.view-names=

```  


# 一般开发中将spring.thymeleaf.cache设置为false，其他保持默认值即可。

* http://localhost:8080/web/imag/log.jpg 
##  Spring Boot中使用MyBatis  （没有成功）
 
* https://mrbird.cc/Spring-Boot%20Mybatis.html 

* MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。

* 整合MyBatis之前，先搭建一个基本的Spring Boot项目开启Spring Boot。然后引入mybatis-spring-boot-starter和数据库连接驱动（这里使用关系型数据库Oracle 11g）。

 
* 引入ojdbc6 


* 由于版权的原因，我们需要将ojdbc6.jar依赖安装到本地的maven仓库，然后才可以在pom中进行配置。
  下载ojdbc6.jar文件后，将其放到比较好找的目录下，比如D盘根目录。然后运行以下命令：
  
 ```
C:\Users\Administrator>mvn install:install-file -Dfile=D:/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=6.0 -
Dpackaging=jar -DgeneratePom=true

```

* Java连接Oracle数据库， oracle.jdbc.driver jdbc:oracle:thin:@localhost:1521:ORCL :

``` 

E:\Android\github_workspace\SpringDemo\03.Spring-Boot-MyBatis>mvn install:install-file -Dfile=D:/ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=6.0 -Dpackaging=jar -
DgeneratePom=true
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< com.springboot:Spring-Boot-MyBatis >-----------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-install-plugin:2.5.2:install-file (default-cli) @ Spring-Boot-MyBatis ---
[INFO] pom.xml not found in ojdbc6.jar
[INFO] Installing D:\ojdbc6.jar to D:\m2\repository\com\oracle\ojdbc6\6.0\ojdbc6-6.0.jar
[INFO] Installing C:\Users\win7\AppData\Local\Temp\mvninstall7486692249287871604.pom to D:\m2\repository\com\oracle\ojdbc6\6.0\ojdbc6-6.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.606 s
[INFO] Finished at: 2018-09-26T09:56:06+08:00
[INFO] ------------------------------------------------------------------------

E:\Android\github_workspace\SpringDemo\03.Spring-Boot-MyBatis>

```








* 配置不但配置了Druid作为连接池，而且还开启了Druid的监控功能。(https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98) 其他配置可参考官方wiki——https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
此时，运行项目，访问http://localhost:8080/web/druid 

```
        # 需要账号密码才能访问控制台
        login-username: druid
        login-password: druid123 
```
  
*  如果说  server:  context-path: /web ，请求的路径后面的加上 wenb 切记！ 


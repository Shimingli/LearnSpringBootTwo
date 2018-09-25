##  spring boot项目打包成war并在tomcat上运行的步骤
* https://blog.csdn.net/yalishadaa/article/details/70037846 

* <!-- spring-boot-starter-parent指定了当前项目为一个Spring Boot项目，-->

* spring-boot-starter-web
* Spring Boot提供了许多开箱即用的依赖模块，这些模块都是以spring-boot-starter-XX命名的。比如要开启Spring Boot的web功能，只需要在pom.xml中配置spring-boot-starter-web即可

* spring-boot-maven-plugin
  spring-boot-maven-plugin为Spring Boot Maven插件，提供了：
 
  把项目打包成一个可执行的超级JAR（uber-JAR）,包括把应用程序的所有依赖打入JAR文件内，并为JAR添加一个描述文件，其中的内容能让你用java -jar来运行应用程序。
 
  搜索public static void main()方法来标记为可运行类。
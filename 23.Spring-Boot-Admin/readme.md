## 使用Spring Boot Admin监控服务
在使用Actuator监控Spring Boot应用一节中我们介绍了使用Actuator来监控Spring Boot应用，其提供了许多REST接口来查看应用的信息。但其返回的是大量的JSON格式数据，信息看上去不直观也不易于理解。而Spring Boot Admin（SBA）是一款基于Actuator开发的开源软件：https://github.com/codecentric/spring-boot-admin，以图形化界面的方式展示Spring Boot应用的配置信息、Beans信息、环境属性、线程信息、JVM状况等。本文使用的Spring Boot Admin版本为1.5.7，有能力的朋友可以直接阅读官方文档：http://codecentric.github.io/spring-boot-admin/1.5.7。

搭建SBA服务端
搭建一个SBA服务端（Server），其他被监控的Spring Boot应用作为客户端（Client），客户端通过HTTP的方式将自己注册到服务端，以供服务端进行监控服务。大致关系如下图所示：
##  使用Actuator监控Spring Boot应用 

* 我们都知道Spring Boot是一个用于快速开发Java Web的框架，不需要太多的配置即可使用Spring的大量功能。Spring Boot遵循着“约定大于配置”的原则，许多功能使用默认的配置即可。这样的做法好处在于我们不需要像使用Spring那样编写一大堆的XML配置代码，但过于简单的配置过程会让我们在了解各种依赖，配置之间的关系过程上带来一些困难。不过没关系，在Spring Boot中，我们可以使用Actuator来监控应用，Actuator提供了一系列的RESTful API让我们可以更为细致的了解各种信息。

引入Actuator
```  
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```

* 配置Actuator

```  
server:
  port: 80
management:
  security:
    enabled: false #关掉安全认证
  port: 80
  context-path: /monitor #actuator的访问路径
endpoints:
  shutdown:
    enabled: true
```

* 配置中关闭了安全认证的功能，如果需要开启这个功能的话还需引入spring-boot-starter-security依赖。除了使用Spring Security来开启监控路径安全认证外，还可以使用Shiro对监控路径进行权限控制。

* 监控的端口和应用一致，配置context-path为/monitor，这样可以避免和自己应用的路径映射地址重复。

* `endpoints.shutdown.enabled: true`提供了使用post请求来关闭Spring Boot应用的功能。


* GET /mappings 描述全部的URI路径，以及它们和控制器(包含Actuator端点)的映射关系
``` 
{
    "/**": {
        "bean": "resourceHandlerMapping"
    },
    "/**/favicon.ico": {
        "bean": "faviconHandlerMapping"
    },
    "/webjars/**": {
        "bean": "resourceHandlerMapping"
    },
    "{[/]}": {
        "bean": "requestMappingHandlerMapping",
        "method": "java.lang.String com.springboot.demo.DemoApplication.index()"
    },
    "{[/error],produces=[text/html]}": {
        "bean": "requestMappingHandlerMapping",
        "method": "public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)"
    },
    "{[/error]}": {
        "bean": "requestMappingHandlerMapping",
        "method": "public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)"
    },
    "{[/shiming/auditevents || /shiming/auditevents.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public org.springframework.http.ResponseEntity<?> org.springframework.boot.actuate.endpoint.mvc.AuditEventsMvcEndpoint.findByPrincipalAndAfterAndType(java.lang.String,java.util.Date,java.lang.String)"
    },
    "{[/shiming/autoconfig || /shiming/autoconfig.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/configprops || /shiming/configprops.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/dump || /shiming/dump.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/env || /shiming/env.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/env/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)"
    },
    "{[/shiming/health || /shiming/health.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(javax.servlet.http.HttpServletRequest,java.security.Principal)"
    },
    "{[/shiming/heapdump || /shiming/heapdump.json],methods=[GET],produces=[application/octet-stream]}": {
        "bean": "endpointHandlerMapping",
        "method": "public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException"
    },
    "{[/shiming/info || /shiming/info.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/instances || /shiming/instances.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/loggers || /shiming/loggers.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/loggers/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.get(java.lang.String)"
    },
    "{[/shiming/loggers/{name:.*}],methods=[POST],consumes=[application/vnd.spring-boot.actuator.v1+json || application/json],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.set(java.lang.String,java.util.Map<java.lang.String, java.lang.String>)"
    },
    "{[/shiming/mappings || /shiming/mappings.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/metrics || /shiming/metrics.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/shiming/metrics/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)"
    },
    "{[/shiming/shutdown || /shiming/shutdown.json],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.ShutdownMvcEndpoint.invoke()"
    },
    "{[/shiming/trace || /shiming/trace.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    }
}

```

```

HTTP 方法	路径	描述
GET	/autoconfig	提供了一份自动配置报告，记录哪些自动配置条件通过了，哪些没通过
GET	/configprops	描述配置属性(包含默认值)如何注入Bean
GET	/beans	描述应用程序上下文里全部的Bean，以及它们的关系
GET	/dump	获取线程活动的快照
GET	/env	获取全部环境属性
GET	/env/{name}	根据名称获取特定的环境属性值
GET	/health	报告应用程序的健康指标，这些值由HealthIndicator的实现类提供
GET	/info	获取应用程序的定制信息，这些信息由info打头的属性提供
GET	/mappings	描述全部的URI路径，以及它们和控制器(包含Actuator端点)的映射关系
GET	/metrics	报告各种应用程序度量信息，比如内存用量和HTTP请求计数
GET	/metrics/{name}	报告指定名称的应用程序度量值
POST	/shutdown	关闭应用程序，要求endpoints.shutdown.enabled设置为true
GET	/trace	提供基本的HTTP请求跟踪信息(时间戳、HTTP头等)
```

* 接口使用示例
* autoconfig
  显示所有自动装配类的报告，以及是什么原因导致自动装配成功或者不成功。在浏览器输入：http://localhost/monitor/autoconfig，输出如下（截取部分）：
* beans
    查看Spring 容器管理的Bean,访问http://localhost/monitor/beans，输出如下（截取部分）：
    
*  configprops
    所有＠ConfigurationProperties注解的配置信息，如文件上传的最大允许配置等。访问http://localhost/monitor/configprops，输出如下：
    
*   trace
    /trace接口能查看最近的HTTP 请求和响应，在浏览器输入：http://localhost/monitor/trace，输出如下：
    
* dump
  获取某一时刻虚拟机线程栈信息。线程栈表示某一时刻虚拟机正在做的事情，访问http://localhost/monitor/dump，输出如下（截取部分）：
    
* env
  显示Spring Boot环境变量，如使用的JDK版本、加载的jar包、配置文件信息、日志文件信息。访问，输出如下：
  
* health
  查看所在应用的健康状态， 如磁盘、数据源、Redis 、Elasticsearch等。健康状态分为UP（正常）和DOWN（故障）状态。访问http://localhost/monitor/health，显示如下： 
  
* mappings
  输出所有通过注解＠RequestMapping设置的URL映射，可以通过此来查看URL对应的Controller。访问http://localhost/monitor/mappings，显示如下：
  
* metrics
  显示Spring Boot的性能指标，如己有内存、未占用内存、垃圾回收次数、类信息等。访问http://localhost/monitor/metrics，输出如下：
  
 ``` 
 {
     "classes": 6224,
     "classes.loaded": 6224,
     "classes.unloaded": 0,
     "counter.status.200.shiming.mappings": 2,
     "counter.status.404.star-star": 1,
     "gauge.response.shiming.mappings": 9.0,
     "gauge.response.star-star": 21.0,
     "gc.ps_marksweep.count": 1,
     "gc.ps_marksweep.time": 27,
     "gc.ps_scavenge.count": 4,
     "gc.ps_scavenge.time": 29,
     "heap": 3704832,
     "heap.committed": 311296,
     "heap.init": 262144,
     "heap.used": 183359,
     "httpsessions.active": 0,
     "httpsessions.max": -1,
     "instance.uptime": 290146,
     "mem": 354514,
     "mem.free": 127936,
     "nonheap": 0,
     "nonheap.committed": 44096,
     "nonheap.init": 2496,
     "nonheap.used": 43220,
     "processors": 4,
     "systemload.average": -1.0,
     "threads": 27,
     "threads.daemon": 25,
     "threads.peak": 41,
     "threads.totalStarted": 52,
     "uptime": 292196
 }
 
 ``` 
 
 对/metrics接口提供的信息进行简单分类如下表：
 ``` 
 分类	前缀	报告内容
 垃圾收集器	gc.	已经发生过的垃圾收集次数，以及垃圾收集所耗费的时间，适用于标记-清理垃圾收集器和并行垃圾收集器(数据源自java.lang.management. GarbageCollectorMXBean)
 内存	mem.	分配给应用程序的内存数量和空闲的内存数量(数据源自java.lang. Runtime)
 堆	heap.	当前内存用量(数据源自java.lang.management.MemoryUsage)
 类加载器	classes.	JVM类加载器加载与卸载的类的数量(数据源自java.lang. management.ClassLoadingMXBean)
 系统	processors、instance.uptime、uptime、systemload.average	系统信息，例如处理器数量(数据源自java.lang.Runtime)、运行时间(数据源自java.lang.management.RuntimeMXBean)、平均负载(数据源自java.lang.management.OperatingSystemMXBean)
 线程池	thread.	线程、守护线程的数量，以及JVM启动后的线程数量峰值(数据源自 java.lang .management.ThreadMXBean)
 数据源	datasource.	数据源连接的数量(源自数据源的元数据，仅当Spring应用程序上下文里存在 DataSource Bean 的时候才会有这个信息)
 Tomcat 会话	httpsessions.*	Tomcat的活跃会话数和最大会话数(数据源自嵌入式Tomcat的Bean，仅在使用嵌入式Tomcat服务器运行应用程序时才有这个信息)
 HTTP	counter.status.、gauge.response.	多种应用程序服务HTTP请求的度量值与计数器
 
 ```
 
 HTTP的计数器和度量值需要做一点说明。counter.status后的值是HTTP状态码，随后是所请求的路径。举个例子，counter.status.200.metrics 表明/metrics端点返回 200(OK) 状态码的次数。
 
 HTTP的度量信息在结构上也差不多，却在报告另一类信息。它们全部以gauge.response开头，表明这是HTTP响应的度量信息。前缀后是对应的路径。度量值是以毫秒为单位的时间，反映了最近处理该路径请求的耗时。
 
 这里还有几个特殊的值需要注意。root路径指向的是根路径或/。star-star代表了那些Spring认为是静态资源的路径，包括图片、JavaScript和样式表，其中还包含了那些找不到的资源。这就是为什么你经常会看到counter.status.404.star-star，这是返回了HTTP 404 (NOT FOUND)状态的请求数。
 
 /metrics接口会返回所有的可用度量值，但你也可能只对某个值感兴趣。要获取单个值，请求时可以在URL后加上对应的键名。例如，要查看空闲内存大小,可以向/metrics/mem.free发一个GET请求。
 
 *  tks https://www.jianshu.com/p/af9738634a21
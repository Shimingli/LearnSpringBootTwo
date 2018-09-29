## 搭建Eureka-Server服务注册中心

* 考虑当前有两个微服务实例A和B，A服务需要调用B服务的某个REST接口。假如某一天B服务迁移到了另外一台服务器，IP和端口也发生了变化，这时候我们不得不去修改A服务中调用B服务REST接口的静态配置。随着公司业务的发展，微服务的数量也越来越多，服务间的关系可能变得非常复杂，传统的微服务维护变得愈加困难，也很容易出错。所谓服务治理就是用来实现各个微服务实例的自动化注册与发现，在这种模式下，服务间的调用不再通过指定具体的实例地址来实现，而是通过向服务注册中心获取服务名并发起请求调用实现。
  
  Eureka是由Netflix开发的一款服务治理开源框架，Spring-cloud对其进行了集成。Eureka既包含了服务端也包含了客户端，Eureka服务端是一个服务注册中心(Eureka Server)，提供服务的注册和发现，即当前有哪些服务注册进来可供使用；Eureka客户端为服务提供者(Server Provider)，它将自己提供的服务注册到Eureka服务端，并周期性地发送心跳来更新它的服务租约，同时也能从服务端查询当前注册的服务信息并把它们缓存到本地并周期性地刷新服务状态。这样服务消费者(Server Consumer)便可以从服务注册中心获取服务名称，并消费服务。
  
  
* 说了那么多，我们先来搭建一个Eureka服务端来充当服务注册中心。
   
   新建一个Spring Boot项目，artifactId填Eureka-Service，然后引入Spring Cloud Edgware.SR3和spring-cloud-starter-eureka-server:
   
  ```  
  <dependencyManagement>
      <dependencies>
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-dependencies</artifactId>
              <version>Edgware.SR3</version>
              <type>pom</type>
              <scope>import</scope>
          </dependency>
      </dependencies>
  </dependencyManagement>
  <dependencies>
      <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-eureka-server</artifactId>
      </dependency>
  </dependencies>
  
  ``` 
  
  * 在启动类上添加@EnableEurekaServer注解，表明这是一个Eureka服务端：
    ```  
        @EnableEurekaServer
        @SpringBootApplication
        public class DemoApplication {
            public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class, args);
            }
        }
    ```


* 上面配置了服务的端口为8080，剩下几个为Eureka配置：


 ```
  eureka.instance.hostname指定了Eureka服务端的IP；
  
  eureka.client.register-with-eureka表示是否将服务注册到Eureka服务端，由于自身就是Eureka服务端，所以设置为false；
  
  eureka.client.fetch-registry表示是否从Eureka服务端获取服务信息，因为这里只搭建了一个Eureka服务端，并不需要从别的Eureka服务端同步服务信息，所以这里设置为false；
  
  eureka.client.serviceUrl.defaultZone指定Eureka服务端的地址，默认值为http://localhost:8761/eureka。

``` 

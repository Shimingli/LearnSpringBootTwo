## 搭建Eureka-Client服务提供者 

* 最后配置application.yml：
  ```   
  
    server:
      port: 8082
      
    spring:
      application:
        name: Server-Provider
        
    eureka:
      client:
        register-with-eureka: true
        fetch-registry: true
        serviceUrl:
          defaultZone: http://localhost:8080/eureka/

  
  ```


```
      server.port指定了服务的端口为8082；
      
      spring.application.name指定服务名称为Server-Provider，后续服务消费者要获取上面TestController中接口的时候会用到这个服务名；
      
      eureka.client.serviceUrl.defaultZone指定Eureka服务端的地址，这里为上面定义的Eureka服务端地址；
      
      eureka.client.register-with-eureka和eureka.client.fetch-registry上面已经解释了其意思，虽然这两个配置的默认值就是true，但这里还是显式配置下，使Eureka客户端的功能更为直观（即向服务端注册服务并定时从服务端获取服务缓存到本地）。
```
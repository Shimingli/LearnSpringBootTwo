##  Eureka-Server集群 

* Eureka服务端充当了重要的角色，所有Eureka客户端都将自己提供的服务注册到Eureka服务端，然后供所有服务消费者使用。如果单节点的Eureka服务端宕机了，那么所有服务都无法正常的访问，这必将是灾难性的。为了提高Eureka服务端的可用性，我们一般会对其集群部署，即同时部署多个Eureka服务端，并且可以相互间同步服务。
  
  在搭建Eureka服务端的时候我们曾把下面两个配置给关闭了：
  
 ```
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false

```



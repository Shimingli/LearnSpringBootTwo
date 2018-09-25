## Spring Boot一些基础配置 

### 定制Banner
Spring Boot项目在启动的时候会有一个默认的启动图案：
*我们可以把这个图案修改为自己想要的。在src/main/resources目录下新建banner.txt文件，然后将自己的图案黏贴进去即可。ASCII图案可通过网站 http://www.network-science.de/ascii/ 一键生成，比如输入mrbird生成图案后复制到banner.txt

* [好东西]( http://www.network-science.de/ascii/)

```
                                                         
88    88                                                    
88    88                                                    
88    88                                                    
88    88  ,adPPYba,  8b       d8  ,adPPYba,    88       88  
88    88 a8"     "8a `8b     d8' a8P_____88    88       88  
88    88 8b       d8  `8b   d8'  8PP"""""""    88       88  
88    88 "8a,   ,a8"   `8b,d8'   "8b,   ,aa    "8a,   ,a88  
88    88  `"YbbdP"'      "8"      `"Ybbd8"'     `"YbbdP'Y8  
                                                            
                                                            
                                                                        
          88          88                    88                          
          88          ""                    ""                          
          88                                                            
,adPPYba, 88,dPPYba,  88 88,dPYba,,adPYba,  88 8b,dPPYba,   ,adPPYb,d8  
I8[    "" 88P'    "8a 88 88P'   "88"    "8a 88 88P'   `"8a a8"    `Y88  
 `"Y8ba,  88       88 88 88      88      88 88 88       88 8b       88  
aa    ]8I 88       88 88 88      88      88 88 88       88 "8a,   ,d88  
`"YbbdP"' 88       88 88 88      88      88 88 88       88  `"YbbdP"Y8  
                                                            aa,    ,88  
                                                             "Y8bbdP"   
```


* 设置关闭 banner  `app.setBannerMode(Banner.Mode.OFF);`


* 自定义属性值
Spring Boot允许我们在application.properties下自定义一些属性，比如：
```
mrbird.blog.name=mrbird's blog
mrbird.blog.title=Spring Boot
```

* 定义一个BlogProperties Bean，通过@Value("${属性名}")来加载配置文件中的属性值：  
``` 
@Component
public class BlogProperties {
	
    @Value("${mrbird.blog.name}")
    private String name;
    
    @Value("${mrbird.blog.title}")
    private String title;
    
 
} 
```


* 注解@PropertySource("classpath:test.properties")指明了使用哪个配置文件。要使用该配置Bean，同样也需要在入口类里使用注解@EnableConfigurationProperties({TestConfigBean.class})来启用该配置。


* 在运行Spring Boot jar文件时，可以使用命令java -jar xxx.jar --server.port=8081来改变端口的值。这条命令等价于我们手动到application.properties中修改（如果没有这条属性的话就添加）server.port属性的值为8081。
  如果不想项目的配置被命令行修改，可以在入口文件的main方法中进行如下设置：
``` 
public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setAddCommandLineProperties(false);
    app.run(args);
} 
```

* 使用xml配置
  虽然Spring Boot并不推荐我们继续使用xml配置，但如果出现不得不使用xml配置的情况，Spring Boot允许我们在入口类里通过注解@ImportResource({"classpath:some-application.xml"})来引入xml配置文件。
```
//@ImportResource({"classpath:some-application.xml"})
```  


* Profile配置
  Profile用来针对不同的环境下使用不同的配置文件，多环境配置文件必须以application-{profile}.properties的格式命，其中{profile}为环境标识。比如定义两个配置文件：
  
 *  application-dev.properties：开发环境
   server.port=8080
 * application-prod.properties：生产环境
  server.port=8081

* 至于哪个具体的配置文件会被加载，需要在application.properties文件中通过spring.profiles.active属性来设置，其值对应{profile}值。
  如：spring.profiles.active=dev就会加载application-dev.properties配置文件内容。可以在运行jar文件的时候使用命令java -jar xxx.jar --spring.profiles.active={profile}切换不同的环境配置。
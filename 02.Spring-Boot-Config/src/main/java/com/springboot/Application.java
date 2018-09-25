package com.springboot;

import com.springboot.bean.ConfigBean;
import com.springboot.bean.TestConfigBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class,TestConfigBean.class})//要使用该配置Bean，同样也需要在入口类里使用注解@EnableConfigurationProperties({TestConfigBean.class})来启用该配置。
//@ImportResource({"classpath:some-application.xml"})//虽然Spring Boot并不推荐我们继续使用xml配置，但如果出现不得不使用xml配置的情况，Spring Boot允许我们在入口类里通过注解@ImportResource({"classpath:some-application.xml"})来引入xml配置文件。
public class Application {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		//如果不想项目的配置被命令行修改，可以在入口文件的main方法中进行如下设置
		app.setAddCommandLineProperties(false);
		//设置关闭 banner
		//app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}
}

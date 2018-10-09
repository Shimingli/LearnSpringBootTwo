package com.example.demo.conf;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * webservice 服务端配置
 * 
 * @author adminytf
 */
@EnableWs
@Configuration
public class WSServerConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		// 设置访问根路径
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	/**
	 * 注入服务实例，用于发布wsdl
	 * 
	 * @return
	 */
	@Bean(name = "monitor")
	public DefaultWsdl11Definition defaultWsdl11DefinitionUser() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("MonitorPort");
		// 设置访问路径 http://localhost:8080/ws/monitor.wsdl
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://ws.node.bsutility.com");
		wsdl11Definition.setSchema(monitorSchema());
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema monitorSchema() {
		return new SimpleXsdSchema(new ClassPathResource("monitor.xsd"));
	}

}
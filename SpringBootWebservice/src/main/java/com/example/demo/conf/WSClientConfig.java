package com.example.demo.conf;


import com.example.demo.node.ws.client.MonitorClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * webservice 客户端配置
 * 
 * @author adminytf
 *
 */
@Configuration
public class WSClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// 设置webservice客户端生成文件的包
		marshaller.setContextPath("com.bsutility.node.ws");
		return marshaller;
	}

	/**
	 * 注入客户端实例，以便controller调用
	 * 
	 * @param marshaller
	 * @return
	 */
	@Bean("monitorClient")
	public MonitorClient counrtyClient(Jaxb2Marshaller marshaller) {
		MonitorClient client = new MonitorClient();
		client.setDefaultUri(MonitorClient.URI);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
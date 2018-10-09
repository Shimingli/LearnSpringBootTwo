package com.example.demo.node.ws.server;


import com.example.demo.node.ws.GetMonitorRequest;
import com.example.demo.node.ws.GetMonitorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * webservice 实现类
 * 
 * 
 * @author adminytf
 *
 */
@Endpoint
public class MonitorEndpoint {

	private static final String NAMESPACE_URI = "http://ws.node.bsutility.com";
	@Autowired
	private MonitorRepository monitorRepository;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMonitorRequest")
	@ResponsePayload
	public GetMonitorResponse getMonitor(@RequestPayload GetMonitorRequest request) {
		System.out.println("进入action");
		GetMonitorResponse response = new GetMonitorResponse();
		response.setContainers(monitorRepository.getNodeContainerList(request.getNodeIp()));
		return response;
	}
}

package com.example.demo.node.ws.client;



import com.example.demo.node.ws.GetMonitorRequest;
import com.example.demo.node.ws.GetMonitorResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class MonitorClient extends WebServiceGatewaySupport {
	
	
	/**
	 * 此配置由WSServerConfig.java配置
	 * 
	 * setContextPath
	 */
	public static final String URI = "http://localhost:8080/ws";
	
	/**
	 * 此地址在 MonitorEndpoint.java 配置 
	 * @PayloadRoot 中的 namespace + localPart
	 */
	public static final String SOAPACTION = "http://ws.node.bsutility.com/getMonitorRequest";

	public GetMonitorResponse getMonitor(String nodeIp) {
		GetMonitorRequest request = new GetMonitorRequest();
		request.setNodeIp(nodeIp);
		GetMonitorResponse response = (GetMonitorResponse) getWebServiceTemplate().marshalSendAndReceive(URI, request,
				new SoapActionCallback(SOAPACTION));

		return response;
	}
	public GetMonitorResponse getContainer(String nodeIp) {
		GetMonitorRequest request = new GetMonitorRequest();
		request.setNodeIp(nodeIp);
		GetMonitorResponse response = (GetMonitorResponse) getWebServiceTemplate().marshalSendAndReceive(URI, request,
				new SoapActionCallback(SOAPACTION));
		
		return response;
	}

}
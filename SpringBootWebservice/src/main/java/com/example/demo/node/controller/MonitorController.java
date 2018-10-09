package com.example.demo.node.controller;


import com.example.demo.node.ws.GetMonitorResponse;
import com.example.demo.node.ws.client.MonitorClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author adminytf
 *
 */
@Controller
@RequestMapping("/wsc")
public class MonitorController {

	@Autowired
	private MonitorClient monitorClient;
    //http://localhost:8080/wsc/
	@ResponseBody
	@RequestMapping("/")
	public String get() {
		return "success";
	}

	// http://localhost:8080/wsc/get
	@ResponseBody
	@RequestMapping("/get")
	public String getws() {

		String req = "唱征服";
		GetMonitorResponse response = monitorClient.getMonitor(req);
		System.out.println("response: " + response.getContainers());

		return "success";
	}
}

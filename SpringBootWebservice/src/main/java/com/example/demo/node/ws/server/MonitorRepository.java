package com.example.demo.node.ws.server;

import org.springframework.stereotype.Component;

/**
 * @author adminytf
 *
 */
@Component
public class MonitorRepository {
	public String getNodeContainerList(String nodeIp) {

		return "通了" + nodeIp;
	}
}

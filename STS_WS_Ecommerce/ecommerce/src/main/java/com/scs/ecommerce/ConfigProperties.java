package com.scs.ecommerce;

import java.util.Map;

public class ConfigProperties {

	private Map<String,String> additionalHeaders;
	
	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Map<String, String> getAdditionalHeaders() {
		return additionalHeaders;
	}

	public void setAdditionalHeaders(Map<String, String> additionalHeaders) {
		this.additionalHeaders = additionalHeaders;
	}
}

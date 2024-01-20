package com.spring.ReactCrudApplication.enums;

public enum ApiResponse {
	
	DATA("Data"),SUCCESS("success"),STATUS("status"),KEY("key"),MESSAGE("message"),
	EXCEPTION("Exception"),ERROR("error"),COUNT("count");
	
	String value;

	private ApiResponse(String value) {
		this.value = value;
	}

	public String val() {
		return value;
	}

}

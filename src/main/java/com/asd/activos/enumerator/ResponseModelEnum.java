package com.asd.activos.enumerator;

public enum ResponseModelEnum {
	
	SUCCESS(200L,"Success in process"),
	BAD_REQUEST(400L,"Bad parameter request"),
	NOT_FOUND(404L,"Request with no result"),
	INTERNAL_ERROR(500L,"Internal server error");
	
	private Long code;
	private String description;
	
	ResponseModelEnum(Long code, String description){
		this.code = code;
		this.description = description;
	}

	public Long getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}

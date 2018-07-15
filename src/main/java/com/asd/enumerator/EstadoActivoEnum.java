package com.asd.enumerator;

public enum EstadoActivoEnum {
	
	ACTIVO(1L,"Activo"),
	BAJA(2L,"Dado de baja"),
	REPERACION(3L,"En reparacion"),
	DISPONIBLE(4L,"Disponible"),
	ADIGNADO(5L,"Disponible");
	
	private Long code;
	private String description;
	
	EstadoActivoEnum(Long code, String description){
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

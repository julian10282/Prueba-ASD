package com.asd.activos.enumerator;

public enum EstadoActivoEnum {
	
	ACTIVO(1,"Activo"),
	BAJA(2,"Dado de baja"),
	REPERACION(3,"En reparacion"),
	DISPONIBLE(4,"Disponible"),
	ADIGNADO(5,"Disponible");
	
	private int code;
	private String description;
	
	EstadoActivoEnum(int code, String description){
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}

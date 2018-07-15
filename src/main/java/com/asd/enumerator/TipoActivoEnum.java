package com.asd.enumerator;

public enum TipoActivoEnum {
	
	TERRENO(1,"Terrenos y bienes naturales"),
	CONTRUCCION(2,"Construcciones"),
	INSTALACIONES(3,"Instalaciones técnicas"),
	MAQUINARIA(4,"Maquinaria"),
	MOBILIARIO(5,"Mobiliario"),
	EQUIPOS(6,"Equipos para procesos informáticos"),
	TRANSPORTE(7,"Elementos de transporte"),
	OTROS(8,"Otros");
	
	private int code;
	private String description;
	
	TipoActivoEnum(int code, String description){
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

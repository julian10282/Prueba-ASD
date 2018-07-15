package com.asd.enumerator;

public enum TipoActivoEnum {
	
	TERRENO(1L,"Terrenos y bienes naturales"),
	CONTRUCCION(2L,"Construcciones"),
	INSTALACIONES(3L,"Instalaciones técnicas"),
	MAQUINARIA(4L,"Maquinaria"),
	MOBILIARIO(5L,"Mobiliario"),
	EQUIPOS(6L,"Equipos para procesos informáticos"),
	TRANSPORTE(7L,"Elementos de transporte"),
	OTROS(8L,"Otros");
	
	private Long code;
	private String description;
	
	TipoActivoEnum(Long code, String description){
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

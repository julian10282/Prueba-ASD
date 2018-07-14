package com.asd.activos.persistence.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActivosEntity {
	
	private Integer id;

	private String nombre;
	
	private Integer tipoActivo;
		
	private String serial;
			
	private Integer numeroInterno;
	
	private Float alto;
	
	private Float ancho;
	
	private Float largo;
	
	private Float valorCompra;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaCompra;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaBaja;	
	
	private Integer estado;
	
	private String color;
	
	private String respondable;
	
}

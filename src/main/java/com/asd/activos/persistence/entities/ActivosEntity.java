package com.asd.activos.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Activos", schema="ASD")
public class ActivosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private Integer descripcion;
	
	@Column(name = "tipoActivo")
	private Integer tipoActivo;
	
	@Column(name = "serial")
	private String serial;
	
	@Column(name = "numeroInterno")
	private Integer numeroInterno;
	
	@Column(name = "alto")
	private Float alto;
	
	@Column(name = "ancho")
	private Float ancho;
	
	@Column(name = "largo")
	private Float largo;
	
	@Column(name = "valorCompra")
	private Float valorCompra;
	
	@Column(name = "fechaCompra")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaCompra;
	
	@Column(name = "fechaBaja")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaBaja;	
	
	@Column(name = "estado")
	private Integer estado;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "responsable")
	private String responsable;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActivosEntity [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", tipoActivo=");
		builder.append(tipoActivo);
		builder.append(", serial=");
		builder.append(serial);
		builder.append(", numeroInterno=");
		builder.append(numeroInterno);
		builder.append(", alto=");
		builder.append(alto);
		builder.append(", ancho=");
		builder.append(ancho);
		builder.append(", largo=");
		builder.append(largo);
		builder.append(", valorCompra=");
		builder.append(valorCompra);
		builder.append(", fechaCompra=");
		builder.append(fechaCompra);
		builder.append(", fechaBaja=");
		builder.append(fechaBaja);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", color=");
		builder.append(color);
		builder.append(", responsable=");
		builder.append(responsable);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public Integer getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipoActivo
	 */
	public Integer getTipoActivo() {
		return tipoActivo;
	}

	/**
	 * @param tipoActivo the tipoActivo to set
	 */
	public void setTipoActivo(Integer tipoActivo) {
		this.tipoActivo = tipoActivo;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the numeroInterno
	 */
	public Integer getNumeroInterno() {
		return numeroInterno;
	}

	/**
	 * @param numeroInterno the numeroInterno to set
	 */
	public void setNumeroInterno(Integer numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	/**
	 * @return the alto
	 */
	public Float getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(Float alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public Float getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the largo
	 */
	public Float getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(Float largo) {
		this.largo = largo;
	}

	/**
	 * @return the valorCompra
	 */
	public Float getValorCompra() {
		return valorCompra;
	}

	/**
	 * @param valorCompra the valorCompra to set
	 */
	public void setValorCompra(Float valorCompra) {
		this.valorCompra = valorCompra;
	}

	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}

	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	/**
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}	
	
}

package com.asd.activos.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchModel {
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaCompraInicial;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Bogota")
	private Date fechaCompraFinal;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchModel [fechaCompraInicial=");
		builder.append(fechaCompraInicial);
		builder.append(", fechaCompraFinal=");
		builder.append(fechaCompraFinal);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the fechaCompraInicial
	 */
	public Date getFechaCompraInicial() {
		return fechaCompraInicial;
	}

	/**
	 * @param fechaCompraInicial the fechaCompraInicial to set
	 */
	public void setFechaCompraInicial(Date fechaCompraInicial) {
		this.fechaCompraInicial = fechaCompraInicial;
	}

	/**
	 * @return the fechaCompraFinal
	 */
	public Date getFechaCompraFinal() {
		return fechaCompraFinal;
	}

	/**
	 * @param fechaCompraFinal the fechaCompraFinal to set
	 */
	public void setFechaCompraFinal(Date fechaCompraFinal) {
		this.fechaCompraFinal = fechaCompraFinal;
	}
	
	
}

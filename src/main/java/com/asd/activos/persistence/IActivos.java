package com.asd.activos.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.asd.activos.persistence.entities.ActivosEntity;

public interface IActivos  extends CrudRepository<ActivosEntity, Integer>{
	
	List<ActivosEntity> findByTipoActivo(Integer tipo);

	List<ActivosEntity> findBySerial(String serial);
	
	List<ActivosEntity> findByFechaCompraBetween(Date fechaInicial, Date fechaFinal);
	
}
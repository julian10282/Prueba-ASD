package com.asd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asd.activos.persistence.IActivos;
import com.asd.activos.persistence.entities.ActivosEntity;
import com.asd.enumerator.ResponseModelEnum;
import com.asd.model.ResponseModel;

@Service
public class ActivosController {

	private static final Logger logger = LoggerFactory.getLogger(ActivosController.class);
	
	@Autowired
	IActivos activosCrudRepository;

	public ResponseModel getAllActivosList() {
		
		ResponseModel responseModel = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("getAllActivosList - Buscando todos los activos");
		try {
			List<ActivosEntity> activos = (List<ActivosEntity>) activosCrudRepository.findAll();
			
			if (activos == null) {
				responseModel = new ResponseModel(ResponseModelEnum.NOT_FOUND);
				logger.info("getAllActivosList - [RESPONSE={}]", responseModel);
				return responseModel;
			}
			
		} catch (Exception e) {
			logger.error("getAllActivosList - error ejecutando consulta [ERROR={}]", e);
			return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
		}
		return null;
	}
}

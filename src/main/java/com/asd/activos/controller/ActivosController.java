package com.asd.activos.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asd.activos.enumerator.ResponseModelEnum;
import com.asd.activos.model.ResponseModel;
import com.asd.activos.model.SearchModel;
import com.asd.activos.persistence.IActivos;
import com.asd.activos.persistence.entities.ActivosEntity;

@ManagedBean
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
			logger.info("getAllActivosList - Restulado del query {}", activos);
			
			if (activos == null || activos.isEmpty()) {
				responseModel = new ResponseModel(ResponseModelEnum.NOT_FOUND);
				logger.info("getAllActivosList - [RESPONSE={}]", responseModel);
				return responseModel;
			}
			responseModel.setBody(activos);
			return responseModel;
		} catch (Exception e) {
			logger.error("getAllActivosList - error ejecutando consulta [ERROR={}]", e);
			return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
		}
	}

	public ResponseModel getActivoByTipo(Integer tipo) {
		
		ResponseModel responseModel = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("getActivoByTipo - Buscando activos por tipo");
		
		if (tipo != null) {
			try {
				List<ActivosEntity> activos = activosCrudRepository.findByTipoActivo(tipo);
				logger.info("getActivoByTipo - Restulado del query {}", activos);
				
				if (activos == null || activos.isEmpty()) {
					responseModel = new ResponseModel(ResponseModelEnum.NOT_FOUND);
					logger.info("getActivoByTipo - [RESPONSE={}]", responseModel);
					return responseModel;
				}
				responseModel.setBody(activos);
				return responseModel;
			} catch (Exception e) {
				logger.error("getAllActivosList - error ejecutando consulta [ERROR={}]", e);
				return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
			}
		} else {
			logger.info("getActivoByTipo - missing type information");
			return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
		}
		
	}

	public ResponseModel getActivoBySerial(String serial) {

		ResponseModel responseModel = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("getActivoBySerial - Buscando activos por numero de serial");
		
		if (serial != null) {
			try {
				List<ActivosEntity> activos = activosCrudRepository.findBySerial(serial);
				logger.info("getActivoBySerial - Restulado del query {}", activos);
				
				if (activos == null || activos.isEmpty()) {
					responseModel = new ResponseModel(ResponseModelEnum.NOT_FOUND);
					logger.info("getActivoBySerial - [RESPONSE={}]", responseModel);
					return responseModel;
				}
				responseModel.setBody(activos);
				return responseModel;
			} catch (Exception e) {
				logger.error("getActivoBySerial - error ejecutando consulta [ERROR={}]", e);
				return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
			}
		} else {
			logger.info("getActivoBySerial - missing type information");
			return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
		}
	}

	public ResponseModel getActivoByfechaCompra(SearchModel searchModel) {
		ResponseModel responseModel = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("getActivoByfechaCompra - Buscando activos por fecha de compra");
		
		try {
			List<ActivosEntity> activos = activosCrudRepository.findByFechaCompraBetween(searchModel.getFechaCompraInicial(), searchModel.getFechaCompraFinal());
			logger.info("getActivoByfechaCompra - Restulado del query {}", activos);
			
			if (activos == null || activos.isEmpty()) {
				responseModel = new ResponseModel(ResponseModelEnum.NOT_FOUND);
				logger.info("getActivoByfechaCompra - [RESPONSE={}]", responseModel);
				return responseModel;
			}
			responseModel.setBody(activos);
			return responseModel;
		} catch (Exception e) {
			logger.error("getActivoByfechaCompra - error ejecutando consulta [ERROR={}]", e);
			return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
		}
	}

	public ResponseModel createActivo(ActivosEntity activo) {
		ResponseModel response = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("create - Creando activo");
		
		try {
			activo.setId(0);
			List<ActivosEntity> activos = new ArrayList<>();
			
			ActivosEntity newActivo = activosCrudRepository.save(activo);
			activos.add(newActivo);
			
			logger.info("getActivoByfechaCompra - Restulado del query {}", activos);
			response.setBody(activos);
			
			return response;
		} catch (Exception e) {
			logger.error("getActivoByfechaCompra - error ejecutando consulta [ERROR={}]", e);
			return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
		}
	}

	public ResponseModel updateActivo(ActivosEntity activo) {
		ResponseModel response = new ResponseModel(ResponseModelEnum.SUCCESS);
		logger.info("updateActivo - Actualizando activo");
		
		try {
			Optional<ActivosEntity> optionalOldActivo = activosCrudRepository.findById(activo.getId());
			
			
			if (optionalOldActivo.isPresent()) {
				ActivosEntity oldActivo = optionalOldActivo.get();
				
				if (oldActivo == null) {
					response = new ResponseModel(ResponseModelEnum.NOT_FOUND);
					logger.info("updateActivo - Activo no encontrado [RESPONSE={}]", response);
					return response;
				}
				
				if (validaFechas(activo.getFechaBaja(), oldActivo.getFechaCompra())) {
					response = new ResponseModel(ResponseModelEnum.BAD_REQUEST);
					logger.info("updateActivo - El activo no puede actualizarce debido a que la fecha de baja es menor a la fecha de compra [RESPONSE={}]", response);
					return response;
				}
								
				oldActivo.setFechaBaja(activo.getFechaBaja());
				oldActivo.setSerial(activo.getSerial());
				
				logger.info("updateActivo - Guardando nueva informacion del activo [Activo={}]", oldActivo);
				activosCrudRepository.save(oldActivo);
				
				List<ActivosEntity> activos = new ArrayList<>();
				activos.add(oldActivo);
				response.setBody(activos);
				return response;
				
			} else {
				response = new ResponseModel(ResponseModelEnum.NOT_FOUND);
				logger.info("updateActivo - Activo no encontrado [RESPONSE={}]", response);
				return response;
			}
			
			
		} catch (Exception e) {
			logger.error("getActivoByfechaCompra - error ejecutando consulta [ERROR={}]", e);
			return new ResponseModel(ResponseModelEnum.INTERNAL_ERROR);
		}
	}
	
	private boolean validaFechas(Date fechaBaja, Date fechaCompra) {
		return fechaBaja.before(fechaCompra);
	}

}

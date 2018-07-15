package com.asd.activos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asd.activos.controller.ActivosController;
import com.asd.activos.enumerator.ResponseModelEnum;
import com.asd.activos.model.ResponseModel;
import com.asd.activos.model.SearchModel;
import com.asd.activos.persistence.entities.ActivosEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/activos")
public class ActivosService {

	private static final Logger logger = LoggerFactory.getLogger(ActivosService.class);
	
	@Autowired
	ActivosController activosController;
	
	@GetMapping("/findAll")
	//, method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "getAllActivosList", nickname = "getAllActivosList")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel getAllActivosList(){
		
		logger.info("Requested entire active list");
		
		return activosController.getAllActivosList();
		
	}
	
	@RequestMapping(value = "/findByTipo/{tipo}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "findByTipo", nickname = "findByTipo")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel findByTipo(@PathVariable("tipo") Integer tipo){
		
		logger.info("Requested active by type");
		
		return activosController.getActivoByTipo(tipo);
	}
	
	@RequestMapping(value = "/findBySerial/{serial}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "findBySerial", nickname = "findBySerial")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel findBySerial(@PathVariable("serial") String serial){
		
		logger.info("Requested active by serial");
		
		return activosController.getActivoBySerial(serial);
	}
	
	@RequestMapping(value = "/findByFechaCompra", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "findByFechaCompra", nickname = "findByFechaCompra")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel findByFechaCompra(@RequestBody SearchModel searchModel){
		
		logger.info("Requested active by fecha de compra");
		
		if (searchModel.getFechaCompraFinal() == null || searchModel.getFechaCompraInicial() == null){
			logger.info("Missing request parameters");
			return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
		}
		
		return activosController.getActivoByfechaCompra(searchModel);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "create", nickname = "create")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel create(@RequestBody ActivosEntity activo){
		
		logger.info("Creating active! --");
		
		if (validarParametorActivos(activo) && validaFechas(activo)) {
			return activosController.createActivo(activo);
		} else {
			logger.info("Missing request parameters");
			return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "actualizar", nickname = "actualizar")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "Request with no result"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel updateActivo(@RequestBody ActivosEntity activo){
		
		logger.info("Updating active!");
		
		if (validarParametorActivos(activo) && validaFechas(activo)) {
			if (activo.getId() != 0){
				return activosController.updateActivo(activo);
			}else{
				logger.info("Request must have an id to update active!");
				return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
			}
		} else {
			logger.info("Missing request parameters");
			return new ResponseModel(ResponseModelEnum.BAD_REQUEST);
		}
		
	}

	private boolean validaFechas(ActivosEntity activo) {
		boolean result =  activo.getFechaBaja().after(activo.getFechaCompra());
		logger.info("La fecha de baja debe ser mayo a a la fecha de compra");
		return result;
	}

	private boolean validarParametorActivos(ActivosEntity activo) {
		return activo.getNombre() != null && activo.getDescripcion() != null
				&& activo.getTipoActivo() != null && activo.getSerial() != null
				&& activo.getNumeroInterno() != null && activo.getFechaBaja()!= null
				&& activo.getFechaCompra() != null && activo.getEstado()!= null
				&& activo.getResponsable() != null;
	}
}

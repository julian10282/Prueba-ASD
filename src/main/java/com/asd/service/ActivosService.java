package com.asd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asd.model.ResponseModel;
import com.asd.controller.ActivosController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class ActivosService {

	private static final Logger logger = LoggerFactory.getLogger(ActivosService.class);
	
	@Autowired
	ActivosController activosController;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "getAllActivosList", nickname = "getAllActivosList")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Success", response = ResponseModel.class),
		@ApiResponse(code = 400, message = "Bad parameter request"),
		@ApiResponse(code = 404, message = "URL Request not found"),
		@ApiResponse(code = 500, message = "Internal server error")
		})
	public ResponseModel getAllActivosList(){
		
		logger.info("Requested entire active list");
		
		return activosController.getAllActivosList();
		
	}
}

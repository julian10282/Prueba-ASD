package com.asd.activos.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.asd.activos.persistence.entities.ActivosEntity;

public interface IActivos  extends CrudRepository<ActivosEntity, Integer>{
	
	List<ActivosEntity> findByTipoActivo(Integer tipo);

	List<ActivosEntity> findBySerial(String serial);
	
	List<ActivosEntity> findByFechaCompraBetween(Date fechaInicial, Date fechaFinal);
	
//	@Modifying
//	@Query("SELECT c FROM CampaignEntity c WHERE c.processStatus in :processStatus AND c.status=true AND c.dateToSend <= NOW()")
//	List<CampaignEntity> getProgrammedCampaignsByProcessStatus(@Param("processStatus") List<Integer> processStatus);
//
//	List<CampaignEntity> findByClientIdAndProcessStatus(Integer clientId, int id);
	
}
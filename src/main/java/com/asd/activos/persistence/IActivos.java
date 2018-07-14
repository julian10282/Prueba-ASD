package com.asd.activos.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.asd.activos.persistence.entities.ActivosEntity;

public interface IActivos  extends CrudRepository<ActivosEntity, Integer>{
	
//	ActivosEntity findByIdAndStatus(Integer id, Boolean status);
//	
//	List<ActivosEntity> findByClientIdAndStatus(Integer id, Boolean status);
//	
//	List<ActivosEntity> findByClientId(Long id);
//	
//	Long countByClientId(Integer id);
	
//	@Modifying
//	@Query("SELECT c FROM CampaignEntity c WHERE c.processStatus in :processStatus AND c.status=true AND c.dateToSend <= NOW()")
//	List<CampaignEntity> getProgrammedCampaignsByProcessStatus(@Param("processStatus") List<Integer> processStatus);
//
//	List<CampaignEntity> findByClientIdAndProcessStatus(Integer clientId, int id);
	
}
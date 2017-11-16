package com.amayas.tracer.back.mongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amayas.tracer.back.mongodb.entities.SessionStepDetails;
import com.amayas.tracer.back.mongodb.mapping.SessionStepDetailsMapper;
import com.amayas.tracer.back.mongodb.repositories.SessionStepDetailsRepository;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;

@Service
public class SessionStepDetailsService {
	
	@Autowired
	private SessionStepDetailsRepository sessionStepDetailsRepository;
	
	@Autowired
	private SessionStepDetailsMapper sessionStepDetailsMapper; 
	
	public String saveSessionStepDetails(DetailsInsertLogRequest detailsDto) {
		SessionStepDetails ssd = sessionStepDetailsMapper.dtoToEntity(detailsDto);
		
		// we have to uncompress String data from response
		// before persisting the entity, because mapper 
		// skips this step
		ssd.buildResponse(detailsDto.getLogResponse());
		sessionStepDetailsRepository.save(ssd);
		return ssd.getId();
	}
	
	public TraceSessionStepDetailsResult loadDetailsById(String id) {
		SessionStepDetails ssd = sessionStepDetailsRepository.findById(id);
		return sessionStepDetailsMapper.entityToDto(ssd);
	}

}

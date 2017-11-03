package com.amayas.tracer.back.mongodb.mapping;

import org.mapstruct.Mapper;

import com.amayas.tracer.back.mongodb.entities.SessionStepDetails;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;

@Mapper(componentModel = "spring")
public interface SessionStepDetailsMapper {
	
	public SessionStepDetails dtoToEntity(DetailsInsertLogRequest detailsDto);
	
	public TraceSessionStepDetailsResult entityToDto(SessionStepDetails detailsEntity);
	

}

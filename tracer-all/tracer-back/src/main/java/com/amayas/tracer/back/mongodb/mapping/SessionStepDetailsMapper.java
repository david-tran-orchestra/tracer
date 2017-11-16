package com.amayas.tracer.back.mongodb.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.amayas.tracer.back.mongodb.entities.SessionStepDetails;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.results.TraceSessionStepDetailsResult;

@Mapper(componentModel = "spring")
public interface SessionStepDetailsMapper {
	
	@Mapping(ignore = true, source = "logResponse", target = "logResponse")
	public SessionStepDetails dtoToEntity(DetailsInsertLogRequest detailsDto);
	
	public TraceSessionStepDetailsResult entityToDto(SessionStepDetails detailsEntity);
	

}

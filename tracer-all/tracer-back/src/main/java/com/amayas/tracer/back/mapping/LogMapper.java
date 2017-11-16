package com.amayas.tracer.back.mapping;

import java.util.Date;

import org.mapstruct.Mapper;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;

@Mapper(componentModel = "spring")
public interface LogMapper  {

	default String dateToString(Date d) {
		return null;
	}
	
	/**
	 * Converts a SessionStep entity to a DTO
	 * */
	public SessionStep dtoToEntity(MetaInsertLogRequest ss);

	public TraceSessionStepResult entityToDto(SessionStep req);

}

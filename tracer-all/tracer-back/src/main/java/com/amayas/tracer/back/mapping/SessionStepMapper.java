package com.amayas.tracer.back.mapping;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.orchestra.tracer.dtos.results.TraceSessionStepResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionStepMapper  {
	
	/**
	 * Converts a SessionStep entity to a DTO
	 * */
	public TraceSessionStepResult tracesLogsSessionStepDtoToSessionStep(SessionStep ss);

}

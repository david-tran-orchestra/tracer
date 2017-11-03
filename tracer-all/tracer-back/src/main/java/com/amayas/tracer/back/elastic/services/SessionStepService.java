package com.amayas.tracer.back.elastic.services;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.amayas.tracer.back.elastic.repositories.SessionStepRepository;
import com.amayas.tracer.back.mapping.LogMapper;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionStepService {
	
	@Autowired
	private LogMapper sessionStepMapper;
	
	@Autowired
	private SessionStepRepository sessionStepRepository;
	

	public void saveSessionSteps(MetaInsertLogRequest req) {
		SessionStep ssd = sessionStepMapper.dtoToEntity(req);
		sessionStepRepository.save(ssd);
	}
//	
//	@Transactional
//	public void saveReservationSessionStep(InsertLogRequest req) {
//		
//	}

}

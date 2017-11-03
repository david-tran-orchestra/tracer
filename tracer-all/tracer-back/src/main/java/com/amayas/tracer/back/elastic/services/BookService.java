package com.amayas.tracer.back.elastic.services;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.amayas.tracer.back.elastic.entities.SessionStep;
import com.amayas.tracer.back.elastic.repositories.SessionStepRepository;

@Service
public class BookService {
	
	@Autowired
	private SessionStepRepository sessionStepRepository;
	
//	@Autowired
//	private ElasticsearchTemplate esTemplate;
	
	@PostConstruct
	public void init() {
//		esTemplate.deleteIndex(Book.class);
//        esTemplate.createIndex(Book.class);
//        esTemplate.putMapping(Book.class);
//        esTemplate.refresh(Book.class);
	}


    public SessionStep save(SessionStep book) {
        return sessionStepRepository.save(book);
    }

    public void delete(SessionStep book) {
        sessionStepRepository.delete(book);
    }

    public SessionStep findOne(String id) {
    	Optional<SessionStep> optBook = sessionStepRepository.findById(id);
        return optBook.isPresent() ? optBook.get() : null;
    }

    public Iterable<SessionStep> findAll() {
        return sessionStepRepository.findAll();
    }
    
    public void customSearch() {
    	SearchQuery sq = new NativeSearchQueryBuilder().build();
    	
    }

}

package com.orchestra.tracer.dtos.rest.mappings;

public class RestMapping {
	
	/**
	 * ELASTIC SEARCH REQUESTS
	 * */
	public static final String LOGS_ES = "/es";
	
	public static final String LOGS_ES_INSERT_METAS = LOGS_ES + "/log";
	
	public static final String LOGS_ES_SEARCH_LOGS = LOGS_ES + "/search";
	
	public static final String LOGS_ES_FIND_BY_ID = LOGS_ES + "/{id}";
	
	/**
	 * MONGODB REQUESTS
	 * */
	public static final String LOGS_MONGO = "/mongodb";
	
	public static final String LOGS_MONGO_INSERT_DETAILS = LOGS_MONGO + "/details";
	
	public static final String LOGS_MONGO_LOAD_DETAILS = LOGS_MONGO + "/{id}";
	
	/**
	 * MICROSERVICE REQUESTS
	 * */
	public static final String LOGS_MS = "/logRequest";
	
	public static final String LOGS_MS_META = LOGS_MS + "/meta";
	
	public static final String LOGS_MS_DETAILS_BY_ID = LOGS_MS + "/mongo/{id}";
	
	public static final String LOG_MS_META_FIND_BY_ID = LOGS_MS + "/es/{id}";


}

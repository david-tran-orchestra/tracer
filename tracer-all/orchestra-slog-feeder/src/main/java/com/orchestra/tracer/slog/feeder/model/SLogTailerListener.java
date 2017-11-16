package com.orchestra.tracer.slog.feeder.model;

import org.apache.commons.io.input.TailerListenerAdapter;
import org.apache.commons.lang3.StringUtils;
import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.slog.feeder.actions.SLogsSender;
import com.orchestra.tracer.slog.feeder.utils.MappingUtils;
import com.travelsoft.cameleo.catalog.bookstatistics.data.BrutStatCommon;

/**
 * Created by David on 08/11/2017.
 */
public class SLogTailerListener extends TailerListenerAdapter {

    private String sLogFileName;

    private SLogsSender sender;
    
    private static final String SLOG_ITEMS_SEPARATOR = "##BSTATS:";
    
    private static final String SLOG_XML_TAG = "<?xml";
    
    public SLogTailerListener(String sLogFileName, SLogsSender sender) {
        this.sLogFileName = sLogFileName;
        this.sender = sender;
    }

    @Override
    public void handle(String line) {
    	if(StringUtils.startsWithAny(line, SLOG_ITEMS_SEPARATOR, SLOG_XML_TAG))
    		return;
        try {
	        BrutStatCommon brutStatCommon = MappingUtils.xmlToObject(line, sLogFileName);
	        InsertLogRequest req = MappingUtils.mapToLogRequest(brutStatCommon);
	        sender.send(req);
        } catch(Exception e) {
//        	e.printStackTrace();
        	return;
        }
    }



}
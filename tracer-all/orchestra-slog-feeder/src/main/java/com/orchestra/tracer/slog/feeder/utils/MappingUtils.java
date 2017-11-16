package com.orchestra.tracer.slog.feeder.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.function.Function;

import com.orchestra.tracer.dtos.Channel;
import com.orchestra.tracer.dtos.enums.SubTypeEnum;
import com.orchestra.tracer.dtos.enums.TransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;
import org.apache.commons.lang3.StringUtils;

import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.requests.insert.DetailsInsertLogRequest;
import com.orchestra.tracer.dtos.requests.insert.InsertLogRequest;
import com.orchestra.tracer.dtos.requests.insert.LogResponse;
import com.orchestra.tracer.dtos.requests.insert.MetaInsertLogRequest;
import com.travelsoft.cameleo.catalog.bookstatistics.data.BrutBookStatsInfo;
import com.travelsoft.cameleo.catalog.bookstatistics.data.BrutStatCommon;
import com.travelsoft.cameleo.catalog.bookstatistics.data.InsuranceBrutStatsInfo;
import com.travelsoft.cameleo.catalog.bookstatistics.data.PaymentBrutStatsInfo;

/**
 * Created by David on 08/11/2017.
 */
public class MappingUtils {

    /**
     *
     * @param c
     * @param toUnMarshall
     * @param <T>
     * @return
     */
	
	private static ByteArrayOutputStream bos;
	
	private static synchronized ByteArrayOutputStream getOutputStream() {
		return bos;
	}
	
	private static int minimalCompressionSize = ApplicationContextAccessor.getContext().getBean(PropertiesUtils.class).getMinimalSizeCompression();
	
    public static <T extends BrutStatCommon> T processGenerateData(Class<T> c, String toUnMarshall) {
        T bsi = (T) BrutStatCommon.newFromString(toUnMarshall, c);
        return bsi;
    }

    /**
     *
     * @param xml
     * @param fileName
     * @param <T>
     * @return
     */
    public static <T extends BrutStatCommon> T xmlToObject(String xml, String fileName) {
        BrutStatCommon obj = null;
        if (StringUtils.containsIgnoreCase(fileName, "stats"))
            obj = processGenerateData(BrutBookStatsInfo.class, xml);
        else if (StringUtils.containsIgnoreCase(fileName, "Payment"))
            obj = processGenerateData(PaymentBrutStatsInfo.class, xml);

        return (T) obj;
    }

    /**
     *
     * @param brutStatCommon
     * @param <T>
     * @return
     */
    public static <T extends BrutStatCommon> InsertLogRequest mapToLogRequest(T brutStatCommon) {
        return dataObjectToLogRequest(brutStatCommon);
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static Function<String, ? extends BrutStatCommon> xmlToObject(String fileName) {
        return r -> {
            BrutStatCommon obj = null;
            if (StringUtils.containsIgnoreCase(fileName, "stats"))
                obj = processGenerateData(BrutBookStatsInfo.class, r);
            else if (StringUtils.containsIgnoreCase(fileName, "Payment"))
                obj = processGenerateData(PaymentBrutStatsInfo.class, r);

            return obj;
        };
    }

    public static Function<? super BrutStatCommon, InsertLogRequest> mapToLogRequest() {
        return r -> {
            return dataObjectToLogRequest(r);
        };
    }

    public static InsertLogRequest dataObjectToLogRequest(BrutStatCommon data) {
        InsertLogRequest insertLog = new InsertLogRequest();
        MetaInsertLogRequest metaInsertLog = new MetaInsertLogRequest();
        insertLog.setMetaInsertLogRequest(metaInsertLog);
        DetailsInsertLogRequest detailsInsertLog = new DetailsInsertLogRequest();
        insertLog.setDetailsInsertLogRequest(detailsInsertLog);
        // BrutStatCommon common values
        metaInsertLog.setStatus(StatusEnum.fromString(data.getRepStatus()));

        if(data instanceof BrutBookStatsInfo) {
            BrutBookStatsInfo bookStatsInfo = (BrutBookStatsInfo) data;
            // METAs
            insertLog.setSessionId(bookStatsInfo.getParamNumSessionUser());
            metaInsertLog.setProductCode(bookStatsInfo.getParamCodeProduct());
            metaInsertLog.setDepartureCityIata(bookStatsInfo.getParamDepCity());
            metaInsertLog.setArrivalCityIata(bookStatsInfo.getParamArrCity());
            metaInsertLog.buildChannel(bookStatsInfo.getParamChannelOrgUser());
            metaInsertLog.setType(TypeEnum.BookingProcess);
            metaInsertLog.setSourceCode(bookStatsInfo.getToName());
            metaInsertLog.setStatus(StatusEnum.fromString(bookStatsInfo.getRepStatus()));
            metaInsertLog.setTransactionType(TransactionTypeEnum.valueOf(bookStatsInfo.getTypeReq()));
            metaInsertLog.setTechTransactionType(bookStatsInfo.getTechnicalServicesType());
            metaInsertLog.setDepartureCityIata(bookStatsInfo.getParamDepCity());
            metaInsertLog.setArrivalCityIata(bookStatsInfo.getParamArrCity());
            //duration
            if ("ORCHESTRA".equals(bookStatsInfo.getToName())) {
                metaInsertLog.setSubType(SubTypeEnum.OrxAPI);
            }
            // timestamp
            if (bookStatsInfo.getBookDate() != null) {
                long dateLong = bookStatsInfo.getBookDate().toDate().getTime();
                long timeLong = 0;
                if (bookStatsInfo.getBookHourMin() != null) {
                    timeLong = bookStatsInfo.getBookHourMin().toLong();
                }
                metaInsertLog.setTimeStamp(dateLong + timeLong);
            }
            // booking channel
            if (bookStatsInfo.getParamChannelOrgUser() != null) {
                String[] bookingChannel = bookStatsInfo.getParamChannelOrgUser().split("|");
                Channel channel = new Channel();
                channel.setChannel("null".equals(bookingChannel[0])? bookingChannel[0] : "DEFAULT");
                channel.setOrganization("null".equals(bookingChannel[1])? bookingChannel[1] : "DEFAULT");
                channel.setUser("null".equals(bookingChannel[2])? bookingChannel[2] : "DEFAULT");
            }
            // travellers
            int nbAdults = 0;
            int nbChildren = 0;
            int nbBabies = 0;
            if (bookStatsInfo.getParamPersonsTypes() != null) {
                for(char c : bookStatsInfo.getParamPersonsTypes().toCharArray()) {
                    if ("A".equals(c))
                        nbAdults++;
                    else if ("C".equals(c))
                        nbChildren++;
                    else if ("B".equals(c))
                        nbBabies++;
                }
            }
            metaInsertLog.setNbAdults(nbAdults);
            metaInsertLog.setNbChildren(nbChildren);
            metaInsertLog.setNbBabies(nbBabies);
            // TODO : end of mapping
        } else if(data instanceof PaymentBrutStatsInfo){
            PaymentBrutStatsInfo pbsi = (PaymentBrutStatsInfo) data;
            insertLog.setSessionId(pbsi.getParamNumSessionUser());

        } else if(data instanceof InsuranceBrutStatsInfo) {
            InsuranceBrutStatsInfo ibsi = (InsuranceBrutStatsInfo) data;
            insertLog.setSessionId(ibsi.getParamNumSessionUser());

        }

        // DETAILS
        detailsInsertLog.setLogRequest(data.getRequest());
        try {
            detailsInsertLog.setLogResponse(new LogResponse().buildCompressedResponse(data.getResponse(), getOutputStream(), minimalCompressionSize));
		} catch (IOException e) {
			e.printStackTrace();
		}
        detailsInsertLog.setLogStackTrace(data.getStackTraceContent());
        // TODO : dispoRefTo

        return insertLog;
    }
}

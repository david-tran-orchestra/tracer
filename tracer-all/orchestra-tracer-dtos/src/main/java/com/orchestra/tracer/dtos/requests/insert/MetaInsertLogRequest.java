package com.orchestra.tracer.dtos.requests.insert;

import com.orchestra.tracer.dtos.Channel;
import com.orchestra.tracer.dtos.ErrorData;
import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.enums.SubTypeEnum;
import com.orchestra.tracer.dtos.enums.TechTransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;

import java.util.Date;

/**
 * DTO to insert a meta log request.
 */
public class MetaInsertLogRequest extends AbstractInsertLogRequest implements IInsertLogRequest {

	/** The timestamp of the log. */
	private Long timeStamp;

	/** The type enum. */
	private TypeEnum type;

	/** The booking session id. */
	private String bookingSessionId;

	/** The sub type. */
	private SubTypeEnum subType;

	/** The status. */
	private StatusEnum status;

	/** The transaction type. */
	private TransactionTypeEnum transactionType;

	/** The technical transaction type. */
	private String techTransactionType;

	/** The server instance. */
	private String serverInstance;

	/** The server instance. */
	private String appInstance;

	/** The IP address. */
	private String ipAddress;

	/** The channel. */
	private Channel channel;

	/** The booking ref. */
	private String bookingRef;

	/** The product code. */
	private String productCode;

	/** The IATA departure city. */
	private String departureCityIata;

	/** The IATA arrival city. */
	private String arrivalCityIata;

	/** The start trip date. */
	private Date tripStartDate;

	/** The end trip date. */
	private Date tripEndDate;

	/** The number of adults. */
	private int nbAdults;

	/** The number of children. */
	private int nbChildren;

	/** The number of babies. */
	private int nbBabies;

	/** The id of the details of the log (request, response, dispoRefTo, stackTrace). */
	private String detailsId;

	/** The error data. */
	private ErrorData errorData;

	/** The source code. */
	private String sourceCode;


	public void buildChannel(String pipeSeparatedChannelOrgUser) {
		if(pipeSeparatedChannelOrgUser.contains("|")) {
			String[] tab = pipeSeparatedChannelOrgUser.split("|");
			if(tab != null && tab.length == 3) {
				Channel channel = new Channel();
				channel.setChannel(tab[0]);
				channel.setOrganization(tab[1]);
				channel.setUser(tab[2]);
				setChannel(channel);
			}
		}
	}

	//*************************************
	//*        GETTERS/SETTERS            *
	//*************************************


	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public String getBookingSessionId() {
		return bookingSessionId;
	}

	public void setBookingSessionId(String bookingSessionId) {
		this.bookingSessionId = bookingSessionId;
	}

	public SubTypeEnum getSubType() {
		return subType;
	}

	public void setSubType(SubTypeEnum subType) {
		this.subType = subType;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public TransactionTypeEnum getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypeEnum transactionType) {
		this.transactionType = transactionType;
	}

	public String getTechTransactionType() {
		return techTransactionType;
	}

	public void setTechTransactionType(String techTransactionType) {
		this.techTransactionType = techTransactionType;
	}

	public String getServerInstance() {
		return serverInstance;
	}

	public void setServerInstance(String serverInstance) {
		this.serverInstance = serverInstance;
	}

	public String getAppInstance() {
		return appInstance;
	}

	public void setAppInstance(String appInstance) {
		this.appInstance = appInstance;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDepartureCityIata() {
		return departureCityIata;
	}

	public void setDepartureCityIata(String departureCityIata) {
		this.departureCityIata = departureCityIata;
	}

	public String getArrivalCityIata() {
		return arrivalCityIata;
	}

	public void setArrivalCityIata(String arrivalCityIata) {
		this.arrivalCityIata = arrivalCityIata;
	}

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public int getNbAdults() {
		return nbAdults;
	}

	public void setNbAdults(int nbAdults) {
		this.nbAdults = nbAdults;
	}

	public int getNbChildren() {
		return nbChildren;
	}

	public void setNbChildren(int nbChildren) {
		this.nbChildren = nbChildren;
	}

	public int getNbBabies() {
		return nbBabies;
	}

	public void setNbBabies(int nbBabies) {
		this.nbBabies = nbBabies;
	}

	public String getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(String detailsId) {
		this.detailsId = detailsId;
	}

	public ErrorData getErrorData() {
		return errorData;
	}

	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
}

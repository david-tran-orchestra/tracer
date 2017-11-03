package com.amayas.tracer.back.elastic.entities;

import com.orchestra.tracer.dtos.Channel;
import com.orchestra.tracer.dtos.ErrorData;
import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.enums.SubTypeEnum;
import com.orchestra.tracer.dtos.enums.TechTransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Entity for a Session Step.
 */
@Document(indexName = "tracer", type = "sessionStep", createIndex = false)
public class SessionStep {

	/** The entity id. */
	@Id
    private String id;

	/** The session id. */
	private String sessionId;

	/** The timestamp of the log. */
	private Long timeStamp;

	/** The type enum. */
	private TypeEnum type;

	/** The booking session id. */
	private String bookingSessionId;

	/** The sub type. */
	private SubTypeEnum subType;

	/** The status enum. */
	private StatusEnum status;

	/** The transaction type. */
	private TransactionTypeEnum transactionType;

	/** The technical transavtion type. */
	private TechTransactionTypeEnum techTransactionType;

	/** The server instance. */
	private String serverInstance;

	/** The app instance. */
	private String appInstance;

	/** The ip address. */
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
	// TODO : voir avec @Merkel le lien avec les specs
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


	//*************************************
	//*        GETTERS/SETTERS            *
	//*************************************


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

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

	public TechTransactionTypeEnum getTechTransactionType() {
		return techTransactionType;
	}

	public void setTechTransactionType(TechTransactionTypeEnum techTransactionType) {
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
}

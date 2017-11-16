package com.orchestra.tracer.dtos.results;

import java.util.Date;

import com.orchestra.tracer.dtos.Channel;
import com.orchestra.tracer.dtos.ErrorData;
import com.orchestra.tracer.dtos.enums.ReservationType;
import com.orchestra.tracer.dtos.enums.StatusEnum;
import com.orchestra.tracer.dtos.enums.SubTypeEnum;
import com.orchestra.tracer.dtos.enums.TechTransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TransactionTypeEnum;
import com.orchestra.tracer.dtos.enums.TypeEnum;

public class TraceSessionStepResult {
	
	private String id;
	
	private String sessionId;
	
	private Date date;
	
	private TypeEnum type;
	
	private SubTypeEnum subType;
	
	private String sourceCode;
	
	private StatusEnum status;
	
	private double duration;
	
	private TransactionTypeEnum transactionType;
	
	private TechTransactionTypeEnum techTransactionType;
	
	private Channel channel;
	
	private String serverInstance;
	
	private String appinstance;
	
	private String ipAddress;
	
	private ErrorData errorData;
	
	private String departureCity;
	
	private String destinationCity;
	
	private String bookingRef;
	
	private ReservationType reservationType;
	
	private String productCode;
	
	private Date beginDate;
	
	private Date endDate;
	
	private int nbNights;
	
	private int nbDays;
	
	private int nbAdults;
	
	private int nbChildren;
	
	private int nbBabies;
	
	private String detailsId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Session steps may contain other session steps
	 * according to request type hierarchy
	 * */
	private TraceSessionStepResult[] sessionSteps;
	
	public String getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(String detailsId) {
		this.detailsId = detailsId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public ErrorData getErrorData() {
		return errorData;
	}

	public void setErrorData(ErrorData errorData) {
		this.errorData = errorData;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

	public ReservationType getReservationType() {
		return reservationType;
	}

	public void setReservationType(ReservationType reservationType) {
		this.reservationType = reservationType;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getNbNights() {
		return nbNights;
	}

	public void setNbNights(int nbNights) {
		this.nbNights = nbNights;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
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

	public TraceSessionStepResult[] getSessionSteps() {
		return sessionSteps;
	}

	public void setSessionSteps(TraceSessionStepResult[] sessionSteps) {
		this.sessionSteps = sessionSteps;
	}


	public TypeEnum getType() {
		return type;
	}


	public void setType(TypeEnum type) {
		this.type = type;
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

	public void setDate(Date date) {
		this.date = date;
	}

	public String getServerInstance() {
		return serverInstance;
	}

	public void setServerInstance(String serverInstance) {
		this.serverInstance = serverInstance;
	}

	public String getAppinstance() {
		return appinstance;
	}

	public void setAppinstance(String appinstance) {
		this.appinstance = appinstance;
	}
}

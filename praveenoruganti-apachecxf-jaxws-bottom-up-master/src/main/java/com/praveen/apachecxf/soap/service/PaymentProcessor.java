package com.praveen.apachecxf.soap.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.praveen.apachecxf.soap.dto.PaymentProcessorRequest;
import com.praveen.apachecxf.soap.dto.PaymentProcessorResponse;

@WebService(serviceName = "PaymentProcessor")
public interface PaymentProcessor {

	public @WebResult(name = "response")
	PaymentProcessorResponse processPayment(
			@WebParam(name = "PaymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}

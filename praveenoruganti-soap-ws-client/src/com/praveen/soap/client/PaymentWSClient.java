package com.praveen.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.praveen.apachecxf.soap.service.PaymentProcessor;
import com.praveen.apachecxf.soap.service.PaymentProcessorImplService;
import com.praveen.apachecxf.soap.service.PaymentProcessorRequest;
import com.praveen.apachecxf.soap.service.PaymentProcessorResponse;

public class PaymentWSClient {

	public static void main(String[] args) {

		try {
			PaymentProcessorImplService service = new PaymentProcessorImplService(new URL(
					"http://localhost:8080/praveenoruganti-apachecxf-jaxws-top-down/services/paymentProcessor?wsdl"));
			PaymentProcessor port = service.getPaymentProcessorImplPort();
			Client client = ClientProxy.getClient(port);
			Endpoint endpoint = client.getEndpoint();

			Map<String, Object> props = new HashMap<String, Object>();
			props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
			props.put(WSHandlerConstants.USER, "cxf");
			props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
			props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
			endpoint.getOutInterceptors().add(wssOut);

			PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());

			System.out.println(response.isResult());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}

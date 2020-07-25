package com.praveen.soap.client;

import java.io.IOException;

public class SOAPClient {

	/**
	 * wsimport - JAX-WS top-down web service approach main() method to test/start
	 * soap web service
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//String httpRequestURL = "http://localhost:8080/praveenoruganti-apachecxf-jaxws-bottom-up/services/book/BookService?wsdl";
		String httpRequestURL = "http://localhost:8080/praveenoruganti-apachecxf-jaxws-top-down/services/book/BookService?wsdl";
		String requestXmlParam = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.soap.apachecxf.praveen.com/\">"
				+ " <soapenv:Header/>" + "<soapenv:Body>" + "<ser:getBookNameBasedOnISBN>" + "<arg0>ISBN-2134</arg0>"
				+ " </ser:getBookNameBasedOnISBN>" + "</soapenv:Body>" + "</soapenv:Envelope>";
		System.out.println(httpRequestURL);
		String responseString = ClientUtils.testService(httpRequestURL, requestXmlParam);
		System.out.println("Response String : " + responseString);
	}

}

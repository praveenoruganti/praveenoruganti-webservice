package com.praveen.soap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class RestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		// http://localhost:8080/praveenoruganti-jersey-jaxrs-master/restapi/myresource
		String result = client.target("http://localhost:8080/praveenoruganti-resteasy-jaxrs-master/restapi/myresource")
				.request().get(String.class);
		System.out.println(result);
	}
}

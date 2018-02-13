package com.cluster9.restclient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.cluster9.rest.compte.ClientAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestClientApp {

	public static void main(String[] args) throws Exception {
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTfullServ/clients/").build();
		// add a clientAccount
		String accountStr = "{\"code\":9,\"name\":\"Monstro\",\"townName\":\"NewYork\",\"age\":52}";
		String accountStr2 = "{\"code\":10,\"name\":\"Blogo\",\"townName\":\"SanFrancisco\",\"age\":82}";
		ClientResponse responsePost=client
				.resource(uri)
				.path("accounts")
				.path("create")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, accountStr);
		System.out.println("response to post " + responsePost.getEntity(String.class));
		// do the same with a clientAccount obj and a jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		ClientAccount clientAccount = new ClientAccount(11, "Blurpo", "Newark", 45);
		responsePost = client
				.resource(uri)
				.path("accounts")
				.path("create")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, mapper.writeValueAsString(clientAccount));
		System.out.println("response to post " + responsePost.getEntity(String.class));
		// get the clientAccounts list from the restfull server
		ClientResponse response=client.resource(uri).path("accounts").path("list").get(ClientResponse.class);
		String body = response.getEntity(String.class);
		System.out.println("body: " + body);
		// vers 1:39' : instancier un obj clientAccount  à partir du body de la resp
		ClientAccount[] cl = (ClientAccount[]) new ObjectMapper().readValue(body, ClientAccount[].class);
		System.out.println("cl to string " + cl[0].getName());
		// override to string()
	}

}

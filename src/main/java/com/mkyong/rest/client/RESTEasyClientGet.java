package com.mkyong.rest.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RESTEasyClientGet {
	
	

	public static void main(String[] args) {
		try {
			
			String query = "{\"sqlcmd\" : \"select Node, Severity, count(*) as Cnt from alerts.status group by  Node, Severity;\"}";
			//String url = "http://135.250.138.104:8080/objectserver/restapi/alerts/status";
			String url ="http://135.250.138.104:8080/objectserver/restapi/sql/factory";
			ClientRequest request = new ClientRequest(url);
			request.accept("application/json");
			request.header("Authorization", "BASIC cm9vdA==");
			String input ="select Node, Severity, count(*) as Cnt from alerts.status group by  Node, Severity;";
			request.body("application/json", query);
			
			ClientResponse<String> response = request.post(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

		   System.out.println("status :" + response.getStatus() );

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
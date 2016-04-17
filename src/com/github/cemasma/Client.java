package com.github.cemasma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class Client {
	
	private final String URL = "https://www.turkiye.gov.tr/imei-sorgulama";
	private HttpClient httpClient;
	
	public Client() {
		httpClient = HttpClientBuilder.create().build();
	}
	
	public String connect() {
		HttpGet getRequest = new HttpGet(this.URL);
		try {
			HttpResponse httpResponse = httpClient.execute(getRequest);
			return Util.httpResponseContentToString(httpResponse);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String submitQuery(String imei, String token) {
		HttpPost postRequest = new HttpPost(URL + "?submit");
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add((NameValuePair) new BasicNameValuePair("txtImei", imei));
		urlParameters.add((NameValuePair) new BasicNameValuePair("token", token));
		
		
		
		try {
			postRequest.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) urlParameters));
			
			HttpResponse httpResponse = httpClient.execute(postRequest);
			return Util.httpResponseContentToString(httpResponse);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}	
	}
	
}

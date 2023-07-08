package com.github.cemasma;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Client {
	private final String URL = "https://www.turkiye.gov.tr/imei-sorgulama";
	private final HttpClient httpClient;
	
	public Client() {
		httpClient = HttpClients.createDefault();
	}
	
	public String query(String imei) {
		AtomicReference<String> result = new AtomicReference<>("Query is failed.");

		ClassicHttpRequest mainPageRequest = ClassicRequestBuilder.get(URL).build();


		try {
			httpClient.execute(mainPageRequest, response -> {
				String content = EntityUtils.toString(response.getEntity());

				String token = Util.getTokenInHTML(content);

				ClassicHttpRequest submitRequest = ClassicRequestBuilder.post(URL + "?submit")
						.setEntity(new UrlEncodedFormEntity(Arrays.asList(
								new BasicNameValuePair("txtImei", imei),
								new BasicNameValuePair("token", token))))
						.build();
				httpClient.execute(submitRequest, classicHttpResponse -> null);

				HttpGet queryRequest = new HttpGet(URL + "?asama=1");
				httpClient.execute(queryRequest, classicHttpResponse -> {
					result.set(Util.getImeiInformationInHTML(EntityUtils.toString(classicHttpResponse.getEntity())));
					return null;
				});

				return null;
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.get();
	}
}

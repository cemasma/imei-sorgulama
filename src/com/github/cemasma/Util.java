package com.github.cemasma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class Util {
	
	//Gönderilen sourceHTML içindeki Html'in içindeki token'ı Jsoup ile parse eder.
	//Parse edilen token'ı String olarak geriye döner.
	public static String getTokenInHTML(String sourceHTML) {
		return Jsoup.parse(sourceHTML).select("input[name=token]").first().attr("value");
	}
	
	//Client ile bağlantı sağladığımız site gönderdiğimiz isteklere HttpResponse tipinde response dönüyor.
	//Gönderilen response'un içeriğini okuyup String tipinde geriye döner.
	public static String httpResponseContentToString(HttpResponse httpResponse) {
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	//Gönderilen sourceHTML içindeki Html'in içinde imei durumunun bulunduğu kısmı parse eder ve
	//geriye imei durumunu String olarak döner.
	public static String getImeiInformationInHTML(String sourceHTML) {
		Elements information = Jsoup.parse(sourceHTML).select("dd");
		return information.get(1).text();
	}
}

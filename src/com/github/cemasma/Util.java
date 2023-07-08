package com.github.cemasma;

import org.jsoup.Jsoup;

public class Util {
	public static String getTokenInHTML(String sourceHTML) {
		return Jsoup.parse(sourceHTML).select("body").get(0).attributes().get("data-token");
	}

	public static String getImeiInformationInHTML(String sourceHTML) {
		return Jsoup.parse(sourceHTML).select("dd").get(1).text();
	}
}

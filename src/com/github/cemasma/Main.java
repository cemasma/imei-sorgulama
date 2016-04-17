package com.github.cemasma;

public class Main {

	public static void main(String[] args) {
		Client client = new Client();
		String sourceHTML = client.connect();

		String imei = "111111111111111";
		String token = Util.getTokenInHTML(sourceHTML);
		
		sourceHTML = client.submitQuery(imei, token);
		String result = Util.getImeiInformationInHTML(sourceHTML);
		System.out.println(result);
	}

}

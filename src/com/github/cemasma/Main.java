package com.github.cemasma;

public class Main {
	public static void main(String[] args) {
		String imei = "111111111111111";
		if (args.length > 0 && args[0].length() == 15) {
			imei = args[0];
		}

		Client client = new Client();
		System.out.println(client.query(imei));
	}
}

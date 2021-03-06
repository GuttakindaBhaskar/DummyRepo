package com.example.demo.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ZeroBounceUtil {
	public boolean checkEmailValidation(String email) {
		boolean res = false;
		String status = "";
		String key = "f212cb4782104f419a5e899d76e70980";
		String ip = "99.123.12.122"; // ip address can be blank
		String targetURL = "https://api.zerobounce.net/v2/validate?api_key=" + key + "&email=" + email + "&ip_address="
				+ ip;
		HttpURLConnection connection = null;
		final String USER_AGENT = "Chrome/78.0.3904.97";
		try {
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("User-Agent", USER_AGENT);
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
			String st = (String) jsonObject.get("status");
			if (st.equalsIgnoreCase("valid")) {
				res = true;
			} else {
				res = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return res;

	}

}

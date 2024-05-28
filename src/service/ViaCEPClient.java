package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import service.exception.ViaCEPException;

public class ViaCEPClient {
	private static final String BASE_URL = "https://viacep.com.br/ws/";

	public static String getAddressInfo(String address) throws ViaCEPException, IOException {
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(BASE_URL + address + "/json");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}

				if (response.toString().contains("\"erro\": true")) {
					throw new ViaCEPException("CEP not recognized.");
				}

				reader.close();
				connection.disconnect();

				return response.toString();
			} else {
				throw new ViaCEPException("Failed to connect. Error code: " + connection.getResponseCode());
			}
		} catch (IOException e) {
			throw new ViaCEPException("Error while accessing ViaCEP API: " + e.getMessage(), e);
		}
	}
}

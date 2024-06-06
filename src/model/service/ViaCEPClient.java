package model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import model.exceptions.ViaCEPException;

public class ViaCEPClient {
	private static final String BASE_URL = "https://viacep.com.br/ws/";

	public static String getAddressInfo(String address) throws ViaCEPException {
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
					throw new ViaCEPException("CEP inválido. Insira um CEP válido para continuar.");
				}

				reader.close();
				connection.disconnect();

				return response.toString();
			}
			throw new ViaCEPException("Falha durante a conexão. Conecte-se a internet para continuar o cadastro.");
		} catch (UnknownHostException e) {
			throw new ViaCEPException("Falha durante a conexão. Conecte-se a internet para continuar o cadastro.");
		} catch (IOException e) {
			throw new ViaCEPException("CEP inválido. Insira um CEP válido para continuar.");
		}
	}
}

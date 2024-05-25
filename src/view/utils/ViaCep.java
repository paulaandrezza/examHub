package view.utils;

import java.io.IOException;

import javax.swing.text.PlainDocument;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.Address;
import service.ViaCEPClient;
import service.exception.ViaCEPException;

@SuppressWarnings("serial")
final public class ViaCep extends PlainDocument {

	public Address searchCep(String address) {
		Address addressObject = null;

		try {
			String response = ViaCEPClient.getAddressInfo(address);
			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
					.create();
			addressObject = gson.fromJson(response, Address.class);
			System.out.println();

		} catch (IOException | ViaCEPException f) {
			System.out.println("There was an error while getting the address: " + f.getMessage());
		}

		return addressObject;
	}
}

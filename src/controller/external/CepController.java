package controller.external;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.entities.external.Address;
import model.exceptions.ViaCEPException;
import model.service.ViaCEPClient;

public class CepController {
	private ViaCEPClient viaCEPClient;

	public Address searchCep(String address) throws Exception {
		Address addressObject = null;

		try {
			String response = ViaCEPClient.getAddressInfo(address);
			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
					.create();
			addressObject = gson.fromJson(response, Address.class);

			return addressObject;
		} catch (ViaCEPException e) {
			throw e;
		}

	}
}

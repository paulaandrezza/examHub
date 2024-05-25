package view.utils;

import java.io.IOException;

import javax.swing.JOptionPane;
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
			String error = f.getMessage();
			System.out.println("There was an error while getting the address: " + error);

			switch (error) {
			case "Error while accessing ViaCEP API: viacep.com.br":
				JOptionPane.showMessageDialog(null, "Conecte-se a internet para continuar o cadastro");
				break;
			case "CEP not recognized.":
				JOptionPane.showMessageDialog(null, "Insira um CEP válido para continuar.");
				break;
			case "Error while accessing ViaCEP API: Unexpected end of file from server":
				JOptionPane.showMessageDialog(null,
						"O campo CEP está em branco. Informe um CEP válido para continuar.");
				break;
			default:
				System.out.println(error);
				JOptionPane.showMessageDialog(null, "Erro no sistema ao buscar o CEP. Tente novamente mais tarde.");
				break;
			}

		}

		return addressObject;
	}
}

package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.Endereco;

public class CorreioService {
    private static final String API_URL = "https://viacep.com.br/ws/%s/json/";

    public static Endereco consultarEnderecoPorCEP(String cep) throws IOException {
        String urlStr = String.format(API_URL, cep);
        URL url = new URL(urlStr);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            try {
				return parseEnderecoFromJSON(response.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            throw new IOException("Erro na consulta: " + responseCode);
        }
		return null;
    }

    private static Endereco parseEnderecoFromJSON(String json) throws ParseException {
        Endereco endereco = new Endereco();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        endereco.setLogradouro((String) jsonObject.get("logradouro"));
        endereco.setComplemento((String) jsonObject.get("complemento"));
        endereco.setBairro((String) jsonObject.get("bairro"));
        endereco.setUf((String) jsonObject.get("uf"));
        return endereco;
    }
}

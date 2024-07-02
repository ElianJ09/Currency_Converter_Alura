package Models;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsulter {
    public Currency searchCoinSelected(String query){

        String APIKEY = "bfa4bee7cc992731089aebec";
        String URL = "https://v6.exchangerate-api.com/v6/" + APIKEY + "/latest/" + query;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Currency.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}

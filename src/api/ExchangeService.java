package api;

import module.ExchangeResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {

    private static final String API_KEY = "79c7d0974fc1d5c70d227589";
    private  static final String URL =
            "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

public ExchangeResponse getRates(String baseCurrency){
    try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + baseCurrency))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), ExchangeResponse.class);

    } catch (Exception e) {
        System.out.println("Erro ao consumir a API:" + e.getMessage());
        return null;
        }
    }
}

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {
    private static final String API_KEY = "85b465be8ccfb47cf5b68a0e";

    public double converter(String moedaOrigem, String moedaDestino, double valor) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + moedaOrigem;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            double taxaConversao = json.getAsJsonObject("conversion_rates")
                    .get(moedaDestino)
                    .getAsDouble();

            return valor * taxaConversao;

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar à API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        return 0.0;
    }
}

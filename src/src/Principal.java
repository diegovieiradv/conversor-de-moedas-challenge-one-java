import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/85b465be8ccfb47cf5b68a0e/latest/USD"))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();

        JsonElement elemento = JsonParser.parseString(resposta.body());
        JsonObject objectRoot = elemento.getAsJsonObject();

        double taxa = objectRoot.get("conversion_rate").getAsDouble();

        System.out.println("Taxa de conversão: " + taxa);

    }
}

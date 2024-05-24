package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ResultadoJson {
    String url = "https://v6.exchangerate-api.com/v6/2d84d3354cd4b4d1ee5fd297/latest/USD";
    String json;


    public ResultadoJson(String Base) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/2d84d3354cd4b4d1ee5fd297/latest/" + Base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        this.json = response.body();
    }

    public ResultadoJson() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        this.json = response.body();
    }

    public String getJson() {
        return json;
    }
}

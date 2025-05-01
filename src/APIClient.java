import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIClient {
    //private static final String API_KEY = "99fa009ccdcc0eab4084c269";
    //private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static String buscarTaxaDeCambio(String from, String to, double amount) throws IOException, InterruptedException {
        String endereco = " https://v6.exchangerate-api.com/v6/99fa009ccdcc0eab4084c269/latest/" + from;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

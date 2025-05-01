import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JSONParser {
    public static double extrairResultado(String json) {
        // Exibe o JSON completo para verificar a estrutura
        System.out.println(json);

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Verifica se a resposta foi "success"
        String status = jsonObject.get("result").getAsString();
        if ("success".equals(status)) {
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double taxa = conversionRates.get("BRL").getAsDouble();
            return taxa;
        } else {
            throw new IllegalArgumentException("Erro na resposta da API: " + status);
        }
    }
}

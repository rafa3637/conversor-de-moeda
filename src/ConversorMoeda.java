import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        DecimalFormat df = new DecimalFormat("#,##0.00");

        do {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("1. USD -> BRL");
            System.out.println("2. BRL -> USD");
            System.out.println("3. EUR -> BRL");
            System.out.println("4. BRL -> EUR");
            System.out.println("5. USD -> EUR");
            System.out.println("6. EUR -> USD");
            System.out.println("0. SAIR");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            String from = "", to = "";

            switch (opcao) {
                case 1: from = "USD"; to = "BRL"; break;
                case 2: from = "BRL"; to = "USD"; break;
                case 3: from = "EUR"; to = "BRL"; break;
                case 4: from = "BRL"; to = "EUR"; break;
                case 5: from = "USD"; to = "EUR"; break;
                case 6: from = "EUR"; to = "USD"; break;
                case 0:
                    System.out.println("Saindo...");
                    continue;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            System.out.print("Digite o valor para a conversão: ");
            double valor = scanner.nextDouble();

            try {
                String json = APIClient.buscarTaxaDeCambio(from, to, valor);
                double taxa = JSONParser.extrairResultado(json);

                double valorConvertido = valor * taxa;

                System.out.printf("Resultad: %s %s = %s %s%n", valor, from,  valorConvertido, to);
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro na comunicação com a API: " + e.getMessage());
            }
        } while (opcao != 0);
        scanner.close();
    }
}

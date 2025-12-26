import api.ExchangeService;
import module.ExchangeResponse;

import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Set<String> MOEDAS_VALIDAS =
            Set.of("BRL", "USD", "EUR", "GBP", "JPY", "ARS");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExchangeService service = new ExchangeService();

        System.out.println("💱 CONVERSOR DE MOEDAS");

        boolean continuar = true;

        while (continuar) {

            String base = lerMoeda(scanner, "Escolha a moeda BASE");

            ExchangeResponse response = service.getRates(base);

            if (response == null) {
                System.out.println(" Erro ao obter taxas da API.");
                continue;
            }

            String destino = lerMoeda(scanner, "Escolha a moeda DESTINO");

            double valor = lerValor(scanner);

            Double taxa = response.getConversion_rates().get(destino);

            if (taxa == null) {
                System.out.println(" Conversão indisponível para essa moeda.");
            } else {
                double resultado = valor * taxa;
                System.out.printf("✅ %.2f %s = %.2f %s%n",
                        valor, base, resultado, destino);
            }

            System.out.print("\nDeseja fazer outra conversão? (SIM/NAO): ");
            continuar = scanner.next().equalsIgnoreCase("S");
        }

        System.out.println("\n👋 Programa finalizado.");
        scanner.close();
    }

    private static String lerMoeda(Scanner scanner, String mensagem) {
        String moeda;

        while (true) {
            System.out.println("\n" + mensagem);
            System.out.println("Moedas disponíveis: " + MOEDAS_VALIDAS);
            System.out.print("> ");

            moeda = scanner.next().toUpperCase();

            if (MOEDAS_VALIDAS.contains(moeda)) {
                return moeda;
            } else {
                System.out.println("Moeda inválida. Tente novamente.");
            }
        }
    }

    private static double lerValor(Scanner scanner) {
        double valor;

        while (true) {
            System.out.print("\nDigite o valor a converter: ");

            try {
                valor = Double.parseDouble(scanner.next());

                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("O valor deve ser maior que zero.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}

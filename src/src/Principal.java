import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();

        int opcao = 0;

        while (opcao != 9) {
            System.out.println("***********************************");
            System.out.println("\n");
            System.out.println("**** Conversor de Moedas ****");
            System.out.println("\n");
            System.out.println("1- Real brasileiro ==> Dólar");
            System.out.println("2- Dólar ==> Real brasileiro");
            System.out.println("3- Real brasileiro ==> Euro");
            System.out.println("4- Euro ==> Real brasileiro");
            System.out.println("5- Peso argentino ==> Dólar");
            System.out.println("6- Dólar ==> Peso argentino");
            System.out.println("7- Peso colombiano ==> Dólar");
            System.out.println("8- Dólar ==> Peso colombiano");
            System.out.println("9- Sair");
            System.out.println("\n");
            System.out.println("***********************************");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Escolha inválida");
                continue;
            }
            String origem = "";
            String destino = "";

            if (opcao == 1) { origem = "BRL"; destino = "USD"; }
            else if (opcao == 2) { origem = "USD"; destino = "BRL"; }
            else if (opcao == 3) { origem = "BRL"; destino = "EUR"; }
            else if (opcao == 4) { origem = "EUR"; destino = "BRL"; }
            else if (opcao == 5) { origem = "ARS"; destino = "USD"; }
            else if (opcao == 6) { origem = "USD"; destino = "ARS"; }
            else if (opcao == 7) { origem = "COP"; destino = "USD"; }
            else if (opcao == 8) { origem = "USD"; destino = "COP"; }
            else if (opcao == 9) {
                System.out.println("Encerrando o conversor...");
                break;
            } else {
                System.out.println("Escolha inválida");
                continue;
            }

            System.out.print("Digite o valor a converter: ");
            double valor;
            try {
                valor = Double.parseDouble(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Valor inválido");
                continue;
            }

            double resultado = conversor.converter(origem, destino, valor);

            if (resultado >= 0) {
                System.out.printf("Valor convertido: %.2f %s = %.2f %s%n", valor, origem, resultado, destino);
            }
            System.out.println();
        }
        entrada.close();
    }
}

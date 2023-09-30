import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        final double INITIAL_AMOUNT = 2500.00;
        final int EXIT_PROGRAM = 4;
        double totalAmount = INITIAL_AMOUNT;

        Scanner scanner = new Scanner(System.in);
        printWelcomeMessage();
        printOperations();

        int userInput = scanner.nextInt();
        while (userInput != EXIT_PROGRAM) {
            if (userInput == 1) {
                String amountMessage = "Seu saldo e de: %.2f".formatted(totalAmount);
                System.out.println(amountMessage);
            } else if (userInput == 2) {
                System.out.println("Digite o valor que quer receber");
                double value = scanner.nextInt();
                totalAmount = receiveTransfer(value, totalAmount);
                printCurrentAmount(totalAmount);
            } else if (userInput == 3) {
                System.out.println("Digite o valor que deseja transferir");
                double value = scanner.nextInt();
                totalAmount = withdraw(value, totalAmount);
                printCurrentAmount(totalAmount);
            } else {
                System.out.println("Operacao invalida");
            }
            printOperations();
            userInput = scanner.nextInt();
        }
    }

    private static void printCurrentAmount(double totalAmount) {
        String message = "Seu Saldo e: %.2f".formatted(totalAmount);
        System.out.println(message);
    }

    private static double withdraw(double value, double amount) {
        if (value > amount) {
            System.out.println("Infelizmente voce nao tem saldo para realizar esse saque");
        } else {
            amount -= value;
        }
        return amount;
    }

    private static double receiveTransfer(double value, double amount) {
        amount += value;
        return amount;
    }

    private static void printWelcomeMessage() {
        String initialMessage = """
                    Bem-Vindo ao Banco Flamengo
                    Cliente: Raphael Fleury
                    Conta: Corrente
                    Saldo Inicial: R$ %.2f
                """.formatted(2500.0);
        System.out.println(initialMessage);
    }
    private static void printOperations() {
        String operationsMessage = """
                    Voce pode realizar as seguintes operecaoes:
                    Digite 1 para consultar saldo
                    Digete 2 para receber uma transferencia
                    Digete 3 para realizar uma transferencia
                    Digite 4 para sair do caixa
                """;
        System.out.println(operationsMessage);
    }
}
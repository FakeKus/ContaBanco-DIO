import java.util.Scanner;

public class ContaTerminal {

    private static String name;
    private static String agency;
    private static int accountNum;
    private static double balance;

    public static void main(String[] args) throws Exception {
        System.out.println("INITIALIZING CONTA TERMINAL\n");

        getAccountDetails();
        System.out.println("Olá " + name + ", obrigado por criar uma conta em "
            + "nosso banco, sua agência é " + agency + ", conta " + accountNum 
            + " e seu saldo " + formatBalance(balance) + " já está disponível para saque.");
        System.out.println();
    }

    private static void getAccountDetails() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o seu nome: ");
            name = scanner.next();
            System.out.println("Digite o número da agência: ");
            agency = scanner.next();
            System.out.println("Digite o número da conta: ");
            accountNum = scanner.nextInt();
            System.out.println("Digite o saldo: ");
            balance = Double.valueOf(scanner.next().replace(",", "."));
            System.out.println();

            scanner.close();

        } catch (NumberFormatException e) {
            System.out.println("Erro ao abrir Scanner:\n" + e.getMessage());
        }
    }

    private static String formatBalance(double balance) {
        String intBalance;
        String decimalBalance;
        if (balance >= 1000) {
            intBalance = String.valueOf(balance).split("\\.")[0];
            decimalBalance = String.valueOf(balance).split("\\.")[1];
            if (decimalBalance.length() < 2) {
                decimalBalance = decimalBalance + "0";
            }

            return (intBalance.replaceAll("\\B(?=(\\d{3})+$)", ".") + "," + decimalBalance);
        } else {
            return String.format("%2f", String.valueOf(balance)).replace(".", ",");
        }
    }
}

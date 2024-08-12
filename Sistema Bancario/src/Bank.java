
import java.util.Scanner;

public class Bank {
    private String ownerAccount;
    private double accountBalance;
    private boolean activeAccount;

    Scanner scanner = new Scanner(System.in);

    //getters & setters


    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    public boolean isActiveAccount() {
        return activeAccount;
    }

    public void setActiveAccount(boolean activeAccount)
    {
        this.activeAccount = activeAccount;
    }

    public void createAccount() {
        System.out.print("Name of the account holder: ");
        ownerAccount = scanner.nextLine();
        activeAccount = true;
        accountBalance = 0;  // Inicializa o saldo como zero
        System.out.println("Account created successfully.");
    }

    // transferir dinheiro
    public void transfer() {

        if(activeAccount != true) {
            System.out.println("First create account");
        } else {

            System.out.print("Transferir: R$");
            double saldoEnviar = scanner.nextDouble();


            if (saldoEnviar > accountBalance) {
                System.out.println("Balance insufficient");
            } else {
                accountBalance = accountBalance - saldoEnviar;
                System.out.println("Transfer completed successfully");
            }
        }
    }
    // receber pix
    public void deposit() {

        if(activeAccount != true) {
            System.out.println("First create account!");
        } else {
            System.out.print("Deseja depositar qual valor? R$");
            double saldoReceber = scanner.nextDouble();

            accountBalance = accountBalance + saldoReceber;
            System.out.println("Saldo depositado com sucesso!");
        }
    }

    public void extract() {
        System.out.println("============================================");
        System.out.println("Owner Account: " + ownerAccount);
        System.out.println("Ballance of account: " + accountBalance);
        System.out.println("============================================");

    }

    public void menu() {
        int chooseMenu;
        do {
            System.out.print("Choose an option (only number)\n" +
                    "1- Create Account\n" +
                    "2- Transfer money\n" +
                    "3- Deposit money\n" +
                    "4- extract\n" +
                    "0- Sair\n" +
                    "Digite a opcao:");
             chooseMenu = scanner.nextInt();
            scanner.nextLine();

            switch (chooseMenu) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    transfer();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    extract();
                    break;
                case 0:
                    System.out.println("Exiting . . .");
                    return;
            }
        } while (chooseMenu != 0);
    }


}

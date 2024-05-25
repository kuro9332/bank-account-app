package bank;

import javax.swing.SwingUtilities;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Load accounts from CSV file
        String file = "Accounts.csv";
        LinkedList<Account> accounts = loadAccountsFromFile(file);

        // Display initial account balances
        for (Account account : accounts) {
            System.out.println(account.getBalance());
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(accounts);
            gui.setVisible(true);
        });
    }

    private static LinkedList<Account> loadAccountsFromFile(String fileName) {
        LinkedList<Account> accounts = new LinkedList<>();
        ReadAccounts readAccounts = new ReadAccounts(fileName);
        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balanceList = readAccounts.getBalances();

        for (int i = 0; i < firstNames.size(); i++) {
            accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
        }

        return accounts;
    }
}


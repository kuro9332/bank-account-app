package bank;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadAccounts {
    BufferedReader reader;
    String url;
    LinkedList<String[]> data = new LinkedList<>();

    public ReadAccounts(String URL) {
        this.url = URL;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.url), StandardCharsets.UTF_8));

            // Skip BOM if present
            reader.mark(1);
            if (reader.read() != 0xFEFF) {
                reader.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                data.add(line.split(",")); // "," represents a comma character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        for (String[] line : data) {
            if (line.length >= 2) { // Ensure there are at least 2 elements in the array
                firstNames.add(line[1]); // Index 1 contains the first name
            } else {
                System.err.println("Invalid line format: " + Arrays.toString(line));
            }
        }
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        for (String[] line : data) {
            if (line.length >= 3) { // Ensure there are at least 3 elements in the array
                lastNames.add(line[2]); // Index 2 contains the last name
            } else {
                System.err.println("Invalid line format: " + Arrays.toString(line));
            }
        }
        return lastNames;
    }

    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accounts = new LinkedList<>();
        for (String[] line : data) {
            if (line.length >= 1) { // Ensure there are at least 1 element in the array
                accounts.add(Integer.parseInt(line[0])); // Index 0 contains the account number
            } else {
                System.err.println("Invalid line format: " + Arrays.toString(line));
            }
        }
        return accounts;
    }

    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        for (String[] line : data) {
            if (line.length >= 4) { // Ensure there are at least 4 elements in the array
                balances.add(Integer.parseInt(line[3])); // Index 3 contains the balance
            } else {
                System.err.println("Invalid line format: " + Arrays.toString(line));
            }
        }
        return balances;
    }
}


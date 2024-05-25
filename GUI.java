package bank;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GUI extends JFrame {
    Transaction transferObject = new Transaction();
    StringBuilder sbAllData = new StringBuilder();
    LinkedList<Account> globalAccounts = new LinkedList<>();
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField depositInput;
    private JTextField accDeposit;
    private JTextField accWithdraw;
    private JTextField withdrawInput;
    private JTextField acc1Transfer;
    private JTextField acc2Transfer;
    private JTextField transferAmount;
    JLabel showAllData = new JLabel("Accounts");
    JButton showAllButton = new JButton("Show Accounts");
    JButton hideAllButton = new JButton("Hide Accounts");
    JButton depositButton = new JButton("deposit");
    JButton withdrawButton = new JButton("withdraw");
    JButton transferButton = new JButton("transfer");

    public GUI(LinkedList<Account> accounts) {
        HandlerClass handlerClass = new HandlerClass();
        this.globalAccounts = accounts;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 886, 502);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 218, 239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        depositInput = new JTextField();
        depositInput.setBounds(100, 231, 105, 21);
        contentPane.add(depositInput);
        depositInput.setColumns(10);
        depositButton.setFont(new Font("Tahoma", Font.BOLD, 11));

        depositButton.addActionListener(handlerClass);
        depositButton.setBounds(86, 259, 97, 21);
        contentPane.add(depositButton);

        accDeposit = new JTextField();
        accDeposit.setBounds(100, 202, 105, 19);
        contentPane.add(accDeposit);
        accDeposit.setColumns(10);

        JLabel lblNewLabel = new JLabel("Account:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(10, 204, 143, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Account:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(10, 70, 135, 13);
        contentPane.add(lblNewLabel_1);

        accWithdraw = new JTextField();
        accWithdraw.setToolTipText("");
        accWithdraw.setColumns(10);
        accWithdraw.setBounds(100, 68, 105, 19);
        contentPane.add(accWithdraw);

        JLabel lblNewLabel_2 = new JLabel("Amount:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setBounds(10, 231, 143, 13);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Amount:");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2_1.setBounds(10, 99, 74, 13);
        contentPane.add(lblNewLabel_2_1);

        withdrawInput = new JTextField();
        withdrawInput.setColumns(10);
        withdrawInput.setBounds(100, 97, 105, 19);
        contentPane.add(withdrawInput);
        withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 11));

        withdrawButton.addActionListener(handlerClass);
        withdrawButton.setBounds(86, 129, 97, 19);
        contentPane.add(withdrawButton);

        JLabel lblNewLabel_3 = new JLabel("Deposit");
        lblNewLabel_3.setForeground(new Color(0, 0, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_3.setBounds(86, 173, 97, 21);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Withdraw");
        lblNewLabel_4.setForeground(new Color(0, 128, 0));
        lblNewLabel_4.setBackground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_4.setBounds(90, 39, 135, 19);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Transfer");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_5.setBounds(86, 315, 119, 21);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("From: ");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_6.setBounds(10, 353, 45, 13);
        contentPane.add(lblNewLabel_6);

        acc1Transfer = new JTextField();
        acc1Transfer.setBounds(100, 346, 105, 20);
        contentPane.add(acc1Transfer);
        acc1Transfer.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("To: ");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_7.setBounds(10, 376, 35, 16);
        contentPane.add(lblNewLabel_7);

        acc2Transfer = new JTextField();
        acc2Transfer.setColumns(10);
        acc2Transfer.setBounds(100, 376, 105, 21);
        contentPane.add(acc2Transfer);

        transferAmount = new JTextField();
        transferAmount.setColumns(10);
        transferAmount.setBounds(100, 407, 105, 21);
        contentPane.add(transferAmount);
        transferButton.setFont(new Font("Tahoma", Font.BOLD, 11));

        transferButton.addActionListener(handlerClass);
        transferButton.setBounds(86, 438, 97, 21);
        contentPane.add(transferButton);

        JLabel lblNewLabel_8 = new JLabel("Amount: ");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_8.setBounds(10, 402, 56, 13);
        contentPane.add(lblNewLabel_8);

        Panel panel = new Panel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(499, 20, 363, 422);
        contentPane.add(panel);
        panel.setLayout(null);
        showAllData.setBounds(10, 63, 330, 227);
        panel.add(showAllData);
        showAllData.setBackground(new Color(255, 255, 255));
        showAllData.setForeground(new Color(255, 255, 255));
        showAllData.setHorizontalAlignment(SwingConstants.CENTER);
        showAllData.setVerticalAlignment(SwingConstants.BOTTOM);
        showAllData.setFont(new Font("Tahoma", Font.BOLD, 14));
        showAllButton.setBounds(116, 317, 162, 33);
        panel.add(showAllButton);
        showAllButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        showAllButton.setBackground(new Color(255, 0, 0));

        hideAllButton.setBounds(116, 360, 162, 33);
        panel.add(hideAllButton);
        hideAllButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        hideAllButton.setBackground(new Color(255, 0, 0));

        JTextArea txtrBankingApp = new JTextArea();
        txtrBankingApp.setEnabled(false);
        txtrBankingApp.setEditable(false);
        txtrBankingApp.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtrBankingApp.setText(" Banking app");
        txtrBankingApp.setBounds(307, 0, 143, 29);
        contentPane.add(txtrBankingApp);

        showAllButton.addActionListener(handlerClass);
        hideAllButton.addActionListener(handlerClass);
    }

    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
                updateDisplay();
            } else if (e.getSource() == hideAllButton) {
                hideDisplay();
            } else if (e.getSource() == depositButton) {
                handleDeposit();
            } else if (e.getSource() == withdrawButton) {
            	handleWithdrawal();
            } else if (e.getSource() == transferButton) {
            handleTransfer();
            }
            }    private void handleDeposit() {
                try {
                    String accountNum = accDeposit.getText();
                    int amount = Integer.parseInt(depositInput.getText());
                    for (Account acc : globalAccounts) {
                        if (String.valueOf(acc.getAccountNum()).equals(accountNum)) {
                            acc.deposit(amount);
                            updateDisplay();
                            writeToCSV(); // Call method to write to CSV
                            JOptionPane.showMessageDialog(null, "Deposit successful!");
                            return;
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(null, "Account not found or insufficient funds");
            }

            private void handleWithdrawal() {
                try {
                    String accountNum = accWithdraw.getText();
                    int amount = Integer.parseInt(withdrawInput.getText());
                    for (Account acc : globalAccounts) {
                        if (String.valueOf(acc.getAccountNum()).equals(accountNum)) {
                            if (acc.getBalance() >= amount) {
                                acc.withdraw(amount);
                                updateDisplay();
                                writeToCSV(); // Call method to write to CSV
                                JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Insufficient funds");
                            }
                            return;
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(null, "Account not found or invalid input");
            }

            private void handleTransfer() {
                try {
                    String fromAccount = acc1Transfer.getText();
                    String toAccount = acc2Transfer.getText();
                    int amount = Integer.parseInt(transferAmount.getText());
                    Account fromAcc = null, toAcc = null;

                    for (Account acc : globalAccounts) {
                        if (String.valueOf(acc.getAccountNum()).equals(fromAccount)) {
                            fromAcc = acc;
                        } else if (String.valueOf(acc.getAccountNum()).equals(toAccount)) {
                            toAcc = acc;
                        }
                        if (fromAcc != null && toAcc != null) {
                            break;
                        }
                    }

                    if (fromAcc != null && toAcc != null && fromAcc.getBalance() >= amount) {
                        transferObject.transfer(fromAcc, toAcc, amount);
                        updateDisplay();
                        writeToCSV(); // Call method to write to CSV
                        JOptionPane.showMessageDialog(null, "Transfer successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Invalid transaction details");
                }
            }

            private void updateDisplay() {
                sbAllData.setLength(0);
                for (Account acc : globalAccounts) {
                    sbAllData.append(acc.getAccountNum()).append(",").append(acc.getFirstName()).append(",")
                            .append(acc.getLastName()).append(",").append(acc.getBalance()).append("\n");
                }
                showAllData.setText("<html><h1>Details</h1><br>" + sbAllData.toString().replace("\n", "<br>") + "</html>");
            }

            private void hideDisplay() {
                showAllData.setText("");
            }

            private void writeToCSV() {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.csv"))) {
                    for (Account acc : globalAccounts) {
                        writer.write(acc.getAccountNum() + "," + acc.getFirstName() + "," + acc.getLastName() + "," + acc.getBalance() + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}

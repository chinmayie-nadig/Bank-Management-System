package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Transactions(String pin) {
        this.pin = pin;

        // Load and scale background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1000, 750);
        add(background);

        // Transaction prompt label
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 18));
        l1.setBounds(320, 170, 400, 30);  // Adjusted label position
        background.add(l1);

        // Initialize buttons
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7};

        for (JButton b : buttons) {
            b.setFocusPainted(false);
            b.setBackground(new Color(230, 240, 255));
            b.setFont(new Font("Arial", Font.BOLD, 13));
        }

        // Button layout inside the black screen
        int screenCenterX = 500;
        int colGap = 180;
        int rowGap = 45;
        int startY = 220;
        int btnWidth = 160;
        int btnHeight = 35;

        b1.setBounds(screenCenterX - colGap, startY, btnWidth, btnHeight);
        b2.setBounds(screenCenterX + 20,    startY, btnWidth, btnHeight);
        b3.setBounds(screenCenterX - colGap, startY + rowGap, btnWidth, btnHeight);
        b4.setBounds(screenCenterX + 20,    startY + rowGap, btnWidth, btnHeight);
        b5.setBounds(screenCenterX - colGap, startY + 2 * rowGap, btnWidth, btnHeight);
        b6.setBounds(screenCenterX + 20,    startY + 2 * rowGap, btnWidth, btnHeight);
        b7.setBounds(screenCenterX + 20,    startY + 3 * rowGap, btnWidth, btnHeight);

        // Add to background
        for (JButton b : buttons) {
            background.add(b);
            b.addActionListener(this);
        }

        // Frame setup
        setLayout(null);
        setSize(1000, 750);
        setLocationRelativeTo(null);
        setUndecorated(false); // Set to true for ATM look
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}

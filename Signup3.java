package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    Signup3(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel l14 = new JLabel(new ImageIcon(i2));
        l14.setBounds(100, 0, 90, 90);
        panel.add(l14);

        // Page label
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        panel.add(l1);

        // Account type
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 140, 200, 30);
        panel.add(l2);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        JRadioButton[] radioButtons = {r1, r2, r3, r4};
        int y = 180;
        for (JRadioButton rb : radioButtons) {
            rb.setFont(new Font("Raleway", Font.BOLD, 16));
            rb.setBackground(Color.WHITE);
            rb.setBounds((rb == r1 || rb == r3) ? 100 : 350, y, 250, 30);
            panel.add(rb);
            if (rb == r2) y += 40;
        }

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(r1); accountGroup.add(r2);
        accountGroup.add(r3); accountGroup.add(r4);

        // Card number
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 300, 200, 30);
        panel.add(l3);

        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330, 300, 250, 30);
        panel.add(l4);

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 330, 200, 20);
        panel.add(l5);

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330, 330, 400, 20);
        panel.add(l6);

        // PIN
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 370, 200, 30);
        panel.add(l7);

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330, 370, 200, 30);
        panel.add(l8);

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(100, 400, 200, 20);
        panel.add(l9);

        // Services
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 450, 200, 30);
        panel.add(l10);

        JCheckBox[] services = {
            c1 = new JCheckBox("ATM CARD"),
            c2 = new JCheckBox("Internet Banking"),
            c3 = new JCheckBox("Mobile Banking"),
            c4 = new JCheckBox("EMAIL Alerts"),
            c5 = new JCheckBox("Cheque Book"),
            c6 = new JCheckBox("E-Statement")
        };

        y = 500;
        for (int i = 0; i < services.length; i++) {
            JCheckBox cb = services[i];
            cb.setFont(new Font("Raleway", Font.BOLD, 16));
            cb.setBackground(Color.WHITE);
            cb.setBounds((i % 2 == 0) ? 100 : 350, y, 200, 30);
            panel.add(cb);
            if (i % 2 != 0) y += 50;
        }

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 680, 600, 20);
        panel.add(c7);

        // Buttons
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250, 720, 100, 30);
        panel.add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(420, 720, 100, 30);
        panel.add(b2);

        // Form No
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700, 10, 70, 30);
        panel.add(l11);

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770, 10, 40, 30);
        panel.add(l12);

        // Set scrollable panel
        panel.setPreferredSize(new Dimension(850, 800));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(scrollPane);

        setSize(850, 600);
        setLocation(400, 100);
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String atype = null;
        if (r1.isSelected()) atype = "Saving Account";
        else if (r2.isSelected()) atype = "Fixed Deposit Account";
        else if (r3.isSelected()) atype = "Current Account";
        else if (r4.isSelected()) atype = "Recurring Deposit Account";

        Random ran = new Random();
        String cardno = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
        String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

        StringBuilder facility = new StringBuilder();
        if (c1.isSelected()) facility.append(" ATM Card");
        if (c2.isSelected()) facility.append(" Internet Banking");
        if (c3.isSelected()) facility.append(" Mobile Banking");
        if (c4.isSelected()) facility.append(" EMAIL Alerts");
        if (c5.isSelected()) facility.append(" Cheque Book");
        if (c6.isSelected()) facility.append(" E-Statement");

        try {
            if (ae.getSource() == b1) {
                if (atype == null) {
                    JOptionPane.showMessageDialog(null, "Please select an account type.");
                } else {
                    Conn c = new Conn();
                    String q1 = "INSERT INTO Signup3 VALUES('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
                    String q2 = "INSERT INTO login VALUES('" + formno + "','" + cardno + "','" + pin + "')";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPin: " + pin);
                    //new Deposit(pin).setVisible(true);
                    //setVisible(false);
                }
            } else if (ae.getSource() == b2) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("").setVisible(true);
    }
}

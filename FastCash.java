package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 960, 1080);
        add(background);

        l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(235, 400, 700, 35);
        background.add(l1);

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

    
        int x1 = 170, x2 = 390;
        int y = 499, gap = 44;
        b1.setBounds(x1, y, 150, 35);
        b2.setBounds(x2, y, 150, 35);
        b3.setBounds(x1, y + gap, 150, 35);
        b4.setBounds(x2, y + gap, 150, 35);
        b5.setBounds(x1, y + gap * 2, 150, 35);
        b6.setBounds(x2, y + gap * 2, 150, 35);
        b7.setBounds(x2, y + gap * 3, 150, 35);

        background.add(b1);
        background.add(b2);
        background.add(b3);
        background.add(b4);
        background.add(b5);
        background.add(b6);
        background.add(b7);

      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setLayout(null);
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            JButton clicked = (JButton) ae.getSource();
            String text = clicked.getText();

            if (text.equals("BACK")) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
                return;
            }

            // Remove "Rs " and get amount
            String amount = text.substring(3);

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            c.s.executeUpdate("INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            setVisible(false);
            new Transactions(pin).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Transaction Failed");
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}

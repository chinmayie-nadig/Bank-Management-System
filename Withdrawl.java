package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;

        // Properly scaled background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(960, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 960, 750);
        add(background);

        // Label
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 250, 400, 35);
        background.add(l1);

        // TextField
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(190, 300, 320, 25);
        background.add(t1);

        // Buttons
        b1 = new JButton("WITHDRAW");
        b1.setBounds(390, 370, 150, 35);
        background.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(390, 420, 150, 35);
        background.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        // Frame config
        setLayout(null);
        setSize(960, 750); // updated height to match typical screen
        setLocationRelativeTo(null); // center window
        setUndecorated(false); // or true for cleaner frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                } else {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}

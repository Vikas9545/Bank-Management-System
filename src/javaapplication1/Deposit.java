package javaapplication1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
import java.text.BreakIterator;

public class Deposit extends JFrame implements ActionListener {

    JFrame f1;
    JLabel l1;
    JTextField t1;
    JButton b1, b2, b3;
    String cardno;

    Deposit(String cardno) {
        this.cardno = cardno;
        f1 = new JFrame();
        f1.setPreferredSize(new Dimension(500, 300));
        f1.setUndecorated(true);
        f1.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black));
        f1.pack();
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        l1 = new JLabel("Enter the amount to be Deposit");
        l1.setBounds(80, 60, 360, 25);
        l1.setFont(new Font("Verdana", Font.BOLD, 18));
        f1.add(l1);

        t1 = new JTextField();
        t1.setBounds(120, 110, 200, 38);
        t1.setFont(new Font("Verdana", Font.BOLD, 20));
        f1.add(t1);

        b1 = new JButton("Deposit");
        b1.setBounds(100, 190, 100, 38);
        f1.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBounds(260, 190, 100, 38);
        f1.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Exit");
        b3.setBounds(200, 250, 100, 38);
        f1.add(b3);
        b3.addActionListener(this);
        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f1.setVisible(false);
            new Main(cardno).setVisible(true);

        }
        if (ae.getSource() == b3) {
            System.exit(0);
        }

        try {

            String amount = t1.getText();
            Date date = new Date();
            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the amount");
            } else {
                Conn c1 = new Conn();
                String s1 = "insert into Depositing values('" + cardno + "','" + date + "','Deposit','" + amount + "')";
                c1.s.executeUpdate(s1);
                JOptionPane.showMessageDialog(null, amount + "Amount Deposited");
                new Main(cardno).setVisible(true);
                f1.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Deposit(" ").setVisible(true);
    }
}

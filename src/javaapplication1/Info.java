/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author vikas
 */
public class Info extends JFrame implements ActionListener {

    JFrame f1;
    JLabel l1, l2, l3, l4;
    JCheckBox c1, c2, c3, c4;
    JButton b1;

    JButton btn1;
    String card;

    Info() {

        f1 = new JFrame();
        f1.setSize(400, 500);
        f1.setLocationRelativeTo(null);
        f1.getContentPane().setBackground(Color.white);
        f1.setLayout(null);

        l1 = new JLabel("Select Account Type:");
        l1.setBounds(20, 30, 180, 20);
        l1.setFont(new Font("Verdana", Font.BOLD, 15));

        c1 = new JCheckBox("Instant Account");
        c1.setBounds(30, 80, 150, 30);
        c1.setFont(new Font("Roboto", Font.BOLD, 12));

        c2 = new JCheckBox("Saving Account");
        c2.setBounds(180, 80, 150, 30);
        c2.setFont(new Font("Roboto", Font.BOLD, 12));

        c3 = new JCheckBox("Current Account");
        c3.setBounds(30, 120, 150, 30);
        c3.setFont(new Font("Roboto", Font.BOLD, 12));

        c4 = new JCheckBox("Premium Account");
        c4.setBounds(180, 120, 150, 30);
        c4.setFont(new Font("Roboto", Font.BOLD, 12));

        l2 = new JLabel("Card No:     XXXX XXXX XXXX X00X");
        l2.setBounds(30, 220, 300, 30);
        l2.setFont(new Font("Roboto", Font.BOLD, 15));

        l3 = new JLabel("Pin : XXXX");
        l3.setBounds(30, 250, 300, 30);
        l3.setFont(new Font("Roboto", Font.BOLD, 15));

        l4 = new JLabel("GENERATING CARD NO :");
        l4.setBounds(30, 190, 300, 30);
        l4.setFont(new Font("Roboto", Font.BOLD, 15));

        b1 = new JButton("Generate");
        b1.setBounds(250, 400, 100, 30);
        b1.setFont(new Font("Roboto", Font.BOLD, 12));

        f1.add(l1);
        f1.add(c1);
        f1.add(c2);
        f1.add(c3);
        f1.add(c4);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(b1);

        b1.addActionListener(this);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String acctype = "";
        if (c1.isSelected()) {
            acctype = "Instant Account";
        } else if (c2.isSelected()) {
            acctype = "Saving Account";
        } else if (c3.isSelected()) {
            acctype = "Current Account";
        } else if (c4.isSelected()) {
            acctype = "Premium Account";
        }

        if (c2.isSelected() && c3.isSelected()) {
            JOptionPane.showMessageDialog(null, "Select Any One");
        }
        Random r1 = new Random();
        Long n;
        n = (r1.nextLong() % 90000000L) + 1234567891234560L;
        long x = Math.abs(n);
        String card = String.valueOf(x);

        Random r2 = new Random();
        long m = (r1.nextLong() % 9000L) + 1000L;
        long q = Math.abs(m);
        String pin = String.valueOf(q);

        try {
            if (ae.getSource() == b1) {

                Conn c1 = new Conn();
                String s1 = "insert into account values('" + acctype + "','" + card + "','" + pin + "')";
                c1.s.executeUpdate(s1);
                JOptionPane.showMessageDialog(null, "Card No " + card + "\n Pin no " + pin);
                new Login().setVisible(true);
                f1.setVisible(false);
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Info().setVisible(true);
    }

}

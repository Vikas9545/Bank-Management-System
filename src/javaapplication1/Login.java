/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    String a, b;
    JFrame frame;
    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1;
    String card;

    Login() {

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);

        l1 = new JLabel("Sign In");
        l1.setBounds(160, 30, 200, 30);
        l1.setFont(new Font("Verdana", Font.BOLD, 25));
        frame.add(l1);

        l2 = new JLabel("Card No");
        l2.setBounds(20, 120, 60, 20);
        l2.setFont(new Font("Verdana", Font.BOLD, 12));
        frame.add(l2);
        l2.setBackground(Color.white);

        l3 = new JLabel("Pin No");
        l3.setBounds(20, 180, 60, 25);
        l3.setFont(new Font("Verdana", Font.BOLD, 12));
        frame.add(l3);

        t1 = new JTextField();
        t1.setBounds(150, 120, 200, 25);
        t1.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 180, 200, 25);
        t2.setFont(new Font("Verdana", Font.BOLD, 15));
        frame.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(250, 280, 100, 30);
        frame.add(b1);
        b1.addActionListener(this);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String cardno = t1.getText();
        String pinno = t2.getText();
        try {
            Conn c1 = new Conn();
            String s1;
            s1 = "select * from account where card='" + cardno + "'and pin='" + pinno + "'";
            ResultSet rs = c1.s.executeQuery(s1);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successfull");
                new Main(cardno).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Login unSuccessfull");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author vikas
 */
public class Signup extends JFrame implements ActionListener {

    JFrame frame;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JTextField name, surname, address, email, city, pincode, phone;
    JButton Register;
    JRadioButton b1, b2;
    JComboBox com1;

    Signup() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(550, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        Random r1 = new Random();
        int n = r1.nextInt(9000) + 1;
        String num = String.valueOf(n);

        frame.setLayout(null);
        l1 = new JLabel("APPLICATION FORM NO");
        l1.setBounds(90, 5, 380, 100);
        l1.setFont(new Font("Verdana", Font.BOLD, 25));

        l2 = new JLabel(num);
        l2.setBounds(450, 10, 90, 90);
        l2.setFont(new Font("Roboto", Font.BOLD, 25));

        l3 = new JLabel("Name");
        l3.setBounds(30, 80, 60, 40);
        l3.setFont(new Font("Roboto", Font.BOLD, 15));

        l4 = new JLabel("Surname");
        l4.setBounds(30, 120, 100, 40);
        l4.setFont(new Font("Roboto", Font.BOLD, 15));

        l5 = new JLabel("Address");
        l5.setBounds(30, 160, 120, 40);
        l5.setFont(new Font("Roboto", Font.BOLD, 15));

        l6 = new JLabel("Email");
        l6.setBounds(30, 200, 200, 40);
        l6.setFont(new Font("Roboto", Font.BOLD, 15));

        l7 = new JLabel("City");
        l7.setBounds(30, 240, 100, 40);
        l7.setFont(new Font("Roboto", Font.BOLD, 15));

        l8 = new JLabel("Gender");
        l8.setBounds(30, 280, 80, 40);
        l8.setFont(new Font("Roboto", Font.BOLD, 15));

        l9 = new JLabel("Phone No");
        l9.setBounds(30, 320, 80, 40);
        l9.setFont(new Font("Roboto", Font.BOLD, 15));

        l10 = new JLabel("Pincode");
        l10.setBounds(30, 360, 80, 40);
        l10.setFont(new Font("Roboto", Font.BOLD, 15));

        l11 = new JLabel("Religion");
        l11.setBounds(30, 400, 80, 40);
        l11.setFont(new Font("Roboto", Font.BOLD, 15));

        String caste[] = {"hindu", "muslim", "punjabi", "gujrati", "tamil"};
        com1 = new JComboBox(caste);
        com1.setBounds(250, 400, 200, 25);
        com1.setBackground(Color.white);

        Register = new JButton("NEXT");
        Register.setBounds(350, 440, 100, 30);
        Register.setBackground(Color.white);

        b1 = new JRadioButton("Male");
        b1.setBounds(250, 280, 100, 30);
        b1.setFont(new Font("Roboto", Font.BOLD, 15));
        b1.setBackground(Color.white);
        b2 = new JRadioButton("Female");
        b2.setBounds(400, 280, 100, 30);
        b2.setFont(new Font("Roboto", Font.BOLD, 15));
        b2.setBackground(Color.white);

        ButtonGroup grp = new ButtonGroup();
        grp.add(b1);
        grp.add(b2);
        name = new JTextField();
        name.setBounds(250, 90, 220, 22);
        surname = new JTextField();
        surname.setBounds(250, 130, 220, 22);
        address = new JTextField();
        address.setBounds(250, 170, 220, 22);
        email = new JTextField();
        email.setBounds(250, 210, 220, 22);
        city = new JTextField();
        city.setBounds(250, 250, 220, 22);
        pincode = new JTextField();
        pincode.setBounds(250, 360, 220, 22);

        phone = new JTextField();
        phone.setBounds(250, 320, 220, 22);

        frame.getContentPane().setBackground(Color.white);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(l9);
        frame.add(l10);
        frame.add(l11);
        frame.add(Register);

        frame.add(name);
        frame.add(surname);
        frame.add(address);
        frame.add(city);
        frame.add(pincode);

        frame.add(phone);
        frame.add(email);

        frame.add(com1);

        frame.add(b1);
        frame.add(b2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Register.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name1 = name.getText();
        String lastname = surname.getText();
        String city1 = city.getText();
        String pincode1 = pincode.getText();
        String email1 = email.getText();
        String address1 = address.getText();
        String phone1 = phone.getText();
        String gender1 = "";
        if (b1.isSelected()) {
            gender1 = "male";

        } else {
            gender1 = "female";
        }

        try {
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "complete the form");
            } else {
                Conn c0 = new Conn();
                String s1 = "insert into bank values('" + name1 + "','" + lastname + "','" + address1 + "','" + city1 + "','" + gender1 + "','" + phone1 + "','" + email1 + "','" + pincode1 + "')";
                c0.s.executeUpdate(s1);
                new Info().setVisible(true);
                frame.setVisible(false);

            }
        } catch (SQLException e) {
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        new Signup().setVisible(true);
    }

}

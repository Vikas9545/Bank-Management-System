package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JFrame j1;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2;
    String cardno;

    Main(String cardno) {
        this.cardno = cardno;
        j1 = new JFrame();
        j1.setPreferredSize(new Dimension(400, 400));
        j1.setUndecorated(true);
        j1.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black));
        j1.pack();

        j1.setLocationRelativeTo(null);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.getContentPane().setBackground(Color.white);

        l1 = new JLabel("Select your Choice");
        l1.setBounds(80, 20, 300, 40);
        l1.setFont(new Font("Roboto", Font.BOLD, 25));
        j1.add(l1);

        l1 = new JLabel(cardno);
        l1.setBounds(280, 2, 300, 40);
        l1.setFont(new Font("Roboto", Font.BOLD, 12));
        j1.add(l1);

        b1 = new JButton("Deposit");
        b1.setBounds(55, 100, 100, 30);
        b1.setBackground(Color.white);
        j1.add(b1);

        b2 = new JButton("Withdrawal");
        b2.setBounds(55, 160, 100, 30);
        b2.setBackground(Color.white);
        j1.add(b2);

        b3 = new JButton("Statement");
        b3.setBounds(235, 100, 100, 30);
        b3.setBackground(Color.white);
        j1.add(b3);

        b4 = new JButton("Balance");
        b4.setBounds(235, 160, 100, 30);
        b4.setBackground(Color.white);
        j1.add(b4);

        b5 = new JButton("Exit");
        b5.setBounds(145, 280, 100, 30);
        j1.add(b5);

        j1.setLayout(null);
        j1.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            j1.setVisible(false);
            new Deposit(cardno).setVisible(true);

        }
        if (e.getSource().equals(b2)) {
            j1.setVisible(false);
            new Withdrawal(cardno).setVisible(true);

        }
        if (e.getSource().equals(b4)) {
            j1.setVisible(false);
            new Balance(cardno).setVisible(true);

        }
        if (e.getSource().equals(b3)) {
            j1.setVisible(false);
            new Mini(cardno).setVisible(true);

        }

        if (e.getSource() == b5) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main(" ").setVisible(true);
    }

}

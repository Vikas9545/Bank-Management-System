package javaapplication1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.*;

/**
 *
 * @author vikas
 */
public class Withdrawal extends JFrame implements ActionListener {

    JFrame f1;
    JLabel l1;
    JTextField t1;
    JButton b1, b2, b3;
    String cardno, balance;

    Withdrawal(String cardno) {
        this.cardno = cardno;
        f1 = new JFrame();
        f1.setPreferredSize(new Dimension(500, 300));
        f1.setUndecorated(true);
        f1.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black));
        f1.pack();
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        l1 = new JLabel("Enter the amount to be Withdrawal");
        l1.setBounds(80, 60, 360, 25);
        l1.setFont(new Font("Verdana", Font.BOLD, 18));
        f1.add(l1);

        t1 = new JTextField();
        t1.setBounds(120, 110, 200, 38);
        t1.setFont(new Font("Verdana", Font.BOLD, 20));
        f1.add(t1);

        b1 = new JButton("Withdrawal");
        b1.setBounds(100, 190, 100, 38);
        f1.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBounds(200, 190, 100, 38);
        f1.add(b2);
        b2.addActionListener(this);
        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String amount = t1.getText();

        Date date = new Date();
        try {
            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to Withdrawal");
            } else {
                Conn c1 = new Conn();
                String s1 = "select * from Depositing where cardno='" + cardno + "'";
                ResultSet r1 = c1.s.executeQuery(s1);
                int bal = 0;
                while (r1.next()) {
                    if ((r1.getString("type").equals("Deposit"))) {
                        bal += Integer.parseInt(r1.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(r1.getString("amount"));
                    }
                }

                if (bal < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "insuffiicient Balance");
                    return;
                }
                String z1 = "insert into Depositing values('" + cardno + "','" + date + "','Withdrawal','" + amount + "')";
                c1.s.executeUpdate(z1);
                JOptionPane.showMessageDialog(null, "amount deposited");
            }
            if (ae.getSource() == b2) {
                new Main(cardno).setVisible(true);
            }
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        new Withdrawal(" ").setVisible(true);
    }
}

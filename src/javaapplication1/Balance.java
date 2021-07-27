package javaapplication1;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.BorderFactory;

public class Balance extends JFrame {

    JFrame f1;
    JLabel l1, l2;
    String cardno;

    Balance(String cardno) {
        this.cardno = cardno;

        f1 = new JFrame();
        f1.setPreferredSize(new Dimension(500, 300));
        f1.setUndecorated(true);
        f1.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2, Color.black));
        f1.pack();
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLayout(null);
        l1 = new JLabel("Total Balance");
        l1.setBounds(80, 60, 360, 25);
        f1.add(l1);

        try {
            Conn c1 = new Conn();
            String s1 = "select * from Depositing";
            ResultSet z1 = c1.s.executeQuery(s1);
            int bal = 0;

            while (z1.next()) {

                if (z1.getString("cardno").equals(cardno)) {
                    if (z1.getString("type").equals("Deposit")) {
                        bal += Integer.parseInt(z1.getString("amount"));
                    }

                    if (z1.getString("type").equals("Withdrawal")) {
                        bal -= Integer.parseInt(z1.getString("amount"));
                    }
                }

            }

            String balance = String.valueOf(bal);
            l2 = new JLabel(balance);
            l2.setBounds(80, 120, 360, 25);
            f1.add(l2);
            f1.setVisible(true);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Balance("").setVisible(true);
    }
}

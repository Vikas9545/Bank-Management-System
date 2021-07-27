package javaapplication1;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Mini extends JFrame {

    JFrame f1;
    JLabel l1, l2, l3;
    String cardno;

    public Mini(String cardno) {
        this.cardno = cardno;
        f1 = new JFrame();
        f1.setPreferredSize(new Dimension(800, 600));
        f1.pack();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setLocationRelativeTo(null);
        f1.setLayout(null);

        l1 = new JLabel("Thank For Using Our Bank");
        l1.setBounds(80, 30, 260, 30);

        l1.setFont(new Font("Roboto", Font.BOLD, 18));
        f1.add(l1);

        l2 = new JLabel();
        l2.setBounds(60, 60, 500, 400);
        f1.add(l2);

        l3 = new JLabel();
        l3.setBounds(60, 80, 360, 25);
        f1.add(l3);

        try {

            Conn c = new Conn();
            String s1 = "select * from Depositing where cardno= '" + cardno + "'";
            ResultSet rs = c.s.executeQuery(s1);
            while (rs.next()) {
                l3.setText(rs.getString("cardno").substring(0, 3) + "XXXXXX" + rs.getString("cardno").substring(9, 16));
            }

        } catch (Exception e) {

        }

        try {
            Date date = new Date();
            Conn c = new Conn();
            String s2 = "select * from Depositing where cardno= '" + cardno + "'";
            ResultSet r1 = c.s.executeQuery(s2);
            while (r1.next()) {
                l2.setText(l2.getText() + "<html>" + r1.getString("cardno") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + r1.getString("date") + "&nbsp;&nbsp;&nbsp;" + r1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + r1.getString("amount") + "<br><br><html>");

            }

        } catch (Exception e) {

        }

        f1.setVisible(true);

    }

    public static void main(String[] args) {
        new Mini(" ").setVisible(true);
    }

}

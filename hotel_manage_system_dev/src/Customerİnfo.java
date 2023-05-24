import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Customerİnfo extends JFrame implements ActionListener{
    JTable table;
    Customerİnfo(){
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel a1 = new JLabel("İD Type");
        a1.setBounds(10,10,100,20);
        add(a1);

        JLabel a2 = new JLabel("İD");
        a2.setBounds(150,10,100,20);
        add(a2);

        JLabel a3 = new JLabel("Name");
        a3.setBounds(300,10,100,20);
        add(a3);

        JLabel a4 = new JLabel("Gender");
        a4.setBounds(400,10,100,20);
        add(a4);

        JLabel a5 = new JLabel("Country");
        a5.setBounds(520,10,100,20);
        add(a5);

        JLabel a6 = new JLabel("Room Number");
        a6.setBounds(640,10,100,20);
        add(a6);

        JLabel a7 = new JLabel("Checkin Time");
        a7.setBounds(750,10,100,20);
        add(a7);

        JLabel a8 = new JLabel("Deposit");
        a8.setBounds(900,10,100,20);
        add(a8);


        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });
        add(back);


        table = new JTable();
        table.setBounds(0,40,1000,400);

        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

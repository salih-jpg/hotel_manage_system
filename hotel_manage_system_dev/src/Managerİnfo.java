import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Managerİnfo extends JFrame implements ActionListener {
    JTable table;
    Managerİnfo(){
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel a1 = new JLabel("Name");
        a1.setBounds(10,10,100,20);
        add(a1);

        JLabel a2 = new JLabel("Age");
        a2.setBounds(150,10,100,20);
        add(a2);

        JLabel a3 = new JLabel("Salary");
        a3.setBounds(320,10,100,20);
        add(a3);

        JLabel a4 = new JLabel("Mail");
        a4.setBounds(450,10,100,20);
        add(a4);

        JLabel a5 = new JLabel("Phone Number");
        a5.setBounds(580,10,100,20);
        add(a5);

        JLabel a6 = new JLabel("Gender");
        a6.setBounds(750,10,100,20);
        add(a6);

        JLabel a7 = new JLabel("Job");
        a7.setBounds(880,10,100,20);
        add(a7);


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
            ResultSet rs = conn.s.executeQuery("select * from employee where job = 'Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

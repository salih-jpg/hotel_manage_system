import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener{
    JTable table;
    Department(){
        setBounds(400,200,700,480);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel a1 = new JLabel("Department");
        a1.setBounds(10,10,100,20);
        add(a1);

        JLabel a2 = new JLabel("Budget");
        a2.setBounds(370,10,100,20);
        add(a2);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280,400,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });
        add(back);


        table = new JTable();
        table.setBounds(0,40,500,400);

        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

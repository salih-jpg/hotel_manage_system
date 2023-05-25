import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    Choice typeOfCar;

    JCheckBox available;
    Pickup(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN, 20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel iblbed = new JLabel("Type of Car");
        iblbed.setBounds(50,100,100,20);
        add(iblbed);

        typeOfCar = new Choice();
        typeOfCar.setBounds(150, 100,200,25);
        add(typeOfCar);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select* from driver");
            while (rs.next()){
                typeOfCar.add(rs.getString("carModel"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }




        JLabel a1 = new JLabel("Name");
        a1.setBounds(30,160,100,20);
        add(a1);

        JLabel a2 = new JLabel("Age");
        a2.setBounds(200,160,100,20);
        add(a2);

        JLabel a3 = new JLabel("Gender");
        a3.setBounds(330,160,100,20);
        add(a3);

        JLabel a4 = new JLabel("Company");
        a4.setBounds(460,160,100,20);
        add(a4);

        JLabel a5 = new JLabel("Car Model");
        a5.setBounds(650,160,100,20);
        add(a5);

        JLabel a6 = new JLabel("Availability");
        a6.setBounds(780,160,100,20);
        add(a6);

        JButton submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from driver where carModel = '"+typeOfCar.getSelectedItem()+"'";
                    ResultSet rs = conn.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e1){
                    e1.printStackTrace();
                }

            }
        });
        add(submit);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });
        add(back);


        table = new JTable();
        table.setBounds(0,200,1000,300);

        add(table);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

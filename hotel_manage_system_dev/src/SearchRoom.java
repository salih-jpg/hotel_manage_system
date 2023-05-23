import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JComboBox bedType;

    JCheckBox available;
    SearchRoom(){

        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Search For a Room");
        text.setFont(new Font("Tahoma",Font.PLAIN, 20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel iblbed = new JLabel("Bed Type");
        iblbed.setBounds(50,100,100,20);
        add(iblbed);

        bedType = new JComboBox(new String[]{"STANDARD","ZIP & LINK","PLATFORM","PANEL","SOFA"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);


        JLabel a1 = new JLabel("Room Number");
        a1.setBounds(10,160,100,20);
        add(a1);

        JLabel a2 = new JLabel("Cleaning Status");
        a2.setBounds(200,160,100,20);
        add(a2);

        JLabel a3 = new JLabel("Status");
        a3.setBounds(400,160,100,20);
        add(a3);

        JLabel a4 = new JLabel("Price");
        a4.setBounds(630,160,100,20);
        add(a4);

        JLabel a5 = new JLabel("Bed Type");
        a5.setBounds(820,160,100,20);
        add(a5);

        JButton submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn conn = new Conn();
                    String query = "select * from room where bed = '"+bedType.getSelectedItem()+"'";
                    String query2 = "select * from room where available = 'Empty' AND bed = '"+bedType.getSelectedItem()+"'";
                    ResultSet rs;
                    if (available.isSelected()){
                        rs = conn.s.executeQuery(query2);
                    }else {
                        rs = conn.s.executeQuery(query);
                    }
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
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

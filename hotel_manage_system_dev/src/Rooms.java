import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {
    JTable table;
    Rooms(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel a1 = new JLabel("Room Number");
        a1.setBounds(10,10,100,20);
        add(a1);

        JLabel a2 = new JLabel("Cleaning Status");
        a2.setBounds(100,10,100,20);
        add(a2);

        JLabel a3 = new JLabel("Status");
        a3.setBounds(200,10,100,20);
        add(a3);

        JLabel a4 = new JLabel("Price");
        a4.setBounds(320,10,100,20);
        add(a4);

        JLabel a5 = new JLabel("Bed Type");
        a5.setBounds(420,10,100,20);
        add(a5);

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
        table.setBounds(0,40,500,400);

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

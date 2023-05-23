import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms extends JFrame {
    JTable table;
    Rooms(){
        setBounds(300,200,1050,600);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);

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
}

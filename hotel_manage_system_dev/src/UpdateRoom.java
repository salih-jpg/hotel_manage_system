import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {


    Choice Ccostumer;
    JTextField tfroom,tfavailability,tfstatus;

    JButton check,update,back;

    UpdateRoom(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,980,450);
        setVisible(true);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Room Status");
        text.setBounds(30,20,250,30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel iblid = new JLabel("Room Number");
        iblid.setBounds(30,80,100,20);
        add(iblid);

        Ccostumer = new Choice();
        Ccostumer.setBounds(200,80,150,25);
        add(Ccostumer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while (rs.next()){
                Ccostumer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel iblroom = new JLabel("Price");
        iblroom.setBounds(30,120,100,20);
        add(iblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel iblavailability = new JLabel("Availability");
        iblavailability.setBounds(30,180,100,20);
        add(iblavailability);

        tfavailability = new JTextField();
        tfavailability.setBounds(200,180,150,25);
        add(tfavailability);

        JLabel iblstatus = new JLabel("Cleaning Status");
        iblstatus.setBounds(30,240,100,20);
        add(iblstatus);

        tfstatus = new JTextField();
        tfstatus.setBounds(200,240,150,25);
        add(tfstatus);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = Ccostumer.getSelectedItem();
                String query = "select * from room where number = '"+number+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        tfroom.setText(rs.getString("price"));
                        tfavailability.setText(rs.getString("available"));
                        tfstatus.setText(rs.getString("clean"));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = Ccostumer.getSelectedItem();
                String price = tfroom.getText();
                String available = tfavailability.getText();
                String status = tfstatus.getText();
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("update room set available = '"+available+"',clean = '"+status+"' where number = '"+number+"'");
                    JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                    new Reception();
                    setVisible(false);

                }catch (Exception e2){
                    e2.printStackTrace();
                }

            }
        });
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

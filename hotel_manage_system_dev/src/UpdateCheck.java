import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice Ccostumer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;

    JButton check,update,back;

    UpdateCheck(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,200,980,500);
        setVisible(true);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Status");
        text.setBounds(90,20,200,30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel iblid = new JLabel("Customer İD");
        iblid.setBounds(30,80,100,20);
        add(iblid);

        Ccostumer = new Choice();
        Ccostumer.setBounds(200,80,150,25);
        add(Ccostumer);

        try {
             Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                Ccostumer.add(rs.getString("customerid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel iblroom = new JLabel("Room Number");
        iblroom.setBounds(30,120,100,20);
        add(iblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel iblname = new JLabel("Name");
        iblname.setBounds(30,160,100,20);
        add(iblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel iblcheckin = new JLabel("Checkin Time");
        iblcheckin.setBounds(30,200,100,20);
        add(iblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        JLabel iblpaid = new JLabel("Amount Paid");
        iblpaid.setBounds(30,240,100,20);
        add(iblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel iblpending = new JLabel("Pending Amount");
        iblpending.setBounds(30,280,100,20);
        add(iblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = Ccostumer.getSelectedItem();
                String query = "select * from customer where customerid = '"+id+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        tfroom.setText(rs.getString("room"));
                        tfname.setText(rs.getString("name"));
                        tfcheckin.setText(rs.getString("time"));
                        tfpaid.setText(rs.getString("deposit"));
                    }
                    ResultSet rs2 =c.s.executeQuery("select * from room where number = '"+tfroom.getText()+"'");
                    while (rs2.next()){
                        String price =rs2.getString("price");
                        int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                        tfpending.setText(""+ amountpaid);
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
        update.setBounds(150,340,100,30);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = Ccostumer.getSelectedItem();
                String room = tfroom.getText();
                String name = tfname.getText();
                String chekin = tfcheckin.getText();
                String deposit = tfpaid.getText();
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"',time = '"+chekin+"',deposit = '"+deposit+"' where customerid = '"+number+"'");
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
        back.setBounds(270,340,100,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


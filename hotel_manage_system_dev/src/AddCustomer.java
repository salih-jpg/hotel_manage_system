import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboid;
    JTextField tfName,tfCountry,tfDeposit;

    JRadioButton rMale, rFemale;

    Choice croom;

    JLabel checkinTime;

    JButton add,back;
    AddCustomer(){

        setBounds(350,200,800,550);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel id = new JLabel("ID");
        id.setBounds(35,80,100,20);
        id.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(id);

        String options[]= {"Turkish ID Card","Passport","Driving License","ACME Villain ID"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel idNumber = new JLabel("Number");
        idNumber.setBounds(35,120,100,20);
        idNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(idNumber);


        JLabel iblName = new JLabel("Name");
        iblName.setBounds(35,160,100,20);
        iblName.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblName);

        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);

        JLabel iblGender = new JLabel("Gender");
        iblGender.setBounds(35,200,100,20);
        iblGender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblGender);

        rMale = new JRadioButton("Male");
        rMale.setBackground(Color.WHITE);
        rMale.setBounds(200,200,60,25);
        add(rMale);

        rFemale = new JRadioButton("Female");
        rFemale.setBackground(Color.WHITE);
        rFemale.setBounds(270,200,100,25);
        add(rFemale);

        JLabel iblCountry = new JLabel("Country");
        iblCountry.setBounds(35,240,100,20);
        iblCountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200,240,150,25);
        add(tfCountry);

        JLabel iblRooms = new JLabel("Room Numbers");
        iblRooms.setBounds(35,280,100,20);
        iblRooms.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblRooms);

        croom = new Choice();
        try {
           Conn conn = new Conn();
           String query = "select* from room where available = 'Empty'" ;
          ResultSet rs = conn.s.executeQuery(query);
          while (rs.next()){

              croom.add(rs.getString("number"));

          }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel iblTime = new JLabel("Checkin Time");
        iblTime.setBounds(35,320,150,20);
        iblTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblTime);

        Date date = new Date();

        checkinTime = new JLabel("" + date);
        checkinTime.setBounds(200,320,150,25);
        checkinTime.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(checkinTime);

        JLabel iblDeposit = new JLabel("Deposit");
        iblDeposit.setBounds(35,360,100,20);
        iblDeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(iblDeposit);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,25);
        back.addActionListener(this);
        add(back);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,360,150,25);
        add(tfDeposit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String name = tfName.getText();
            String gender = null;
            if (rMale.isSelected()){
                gender = "Male";
            } else if (rFemale.isSelected()) {
                gender = "Female";
            }
            String country = tfCountry.getText();
            int room = Integer.parseInt(croom.getSelectedItem());
            String time = checkinTime.getText();
            int deposit = Integer.parseInt(tfDeposit.getText());

            try {
                Conn conn = new Conn();
                String querry = "insert into customer(id, name, gender, country, room, time, deposit) values (?,?,?,?,?,?,?)";
                String querry2 = "update room set available = 'Full' where number = '" + room + "'";
                PreparedStatement statement = conn.c.prepareStatement(querry);
                statement.setString(1, id);
                statement.setString(2,name);
                statement.setString(3, gender);
                statement.setString(4, country);
                statement.setString(5, String.valueOf(room));
                statement.setString(6, time);
                statement.setString(7, String.valueOf(deposit));

                int affectedRows = statement.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Veri başarıyla eklendi.");
                    JOptionPane.showMessageDialog(null, "The Customer added successfully");
                    conn.s.executeUpdate(querry2);
                } else {
                    System.out.println("Veri eklenirken bir hata oluştu.");
                }

                setVisible(false);
                new Reception();
            }catch (Exception e1){
                e1.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Reception();
            
        }

    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRooms extends JFrame implements ActionListener   {

    AddRooms(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(addRoomPanel);
        setBounds(100, 100, 500, 500);
        setVisible(true);
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int number = Integer.parseInt(roomNumbertf.getText());
                String clean = cleaningStatusCb.getSelectedItem().toString();
                String available =avaibleCb.getSelectedItem().toString();
                String price =pricetf.getText();
                String bed = bedTypeCb.getSelectedItem().toString();

                try {
                    Conn conn = new Conn();
                    String querry = "insert into room (clean, available, price, bed) values( ?,?,?,?)";

                    PreparedStatement statement = conn.c.prepareStatement(querry);


                    statement.setString(1, clean);
                    statement.setString(2,available );
                    statement.setString(3, price);
                    statement.setString(4, bed);

                    int affectedRows = statement.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Veri başarıyla eklendi.");
                    } else {
                        System.out.println("Veri eklenirken bir hata oluştu.");
                    }
                    JOptionPane.showMessageDialog(null, "The room added successfully");
                    setVisible(false);
                    new Dashboard();
                   }


                catch (Exception ae) { ae.printStackTrace(); }

            }

        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboard();
                setVisible(false);

            }
        });
    }
    private JPanel addRoomPanel;

    private JLabel addRoomsHead;
    private JLabel cleaningStatus;
    private JLabel price;
    private JLabel bedType;
    private JButton addRoomButton;
    private JButton cancelButton;

    private JTextField pricetf;
    private JComboBox cleaningStatusCb;
    private JComboBox bedTypeCb;
    private JLabel availableCb;
    private JComboBox avaibleCb;

    public void actionPerformed(ActionEvent e) {
    }






}

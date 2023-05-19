import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame   {

    AddRooms(){
        add(addRoomPanel);
        setBounds(100, 100, 500, 500);
        setVisible(true);
    }
    private JPanel addRoomPanel;
    private JLabel roomNumber;
    private JLabel addRoomsHead;
    private JLabel cleaningStatus;
    private JLabel price;
    private JLabel bedType;
    private JButton addRoomButton;
    private JButton cancelButton;
    private JTextField roomNumbertf;
    private JTextField pricetf;
    private JComboBox cleaningStatusCb;
    private JComboBox bedTypeCb;
    private JLabel availableCb;

    public static void main(String[] args) {
        new AddRooms();
    }

}

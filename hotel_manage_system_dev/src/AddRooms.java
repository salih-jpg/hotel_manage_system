import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener   {

    AddRooms(){
        add(addRoomPanel);
        setBounds(100, 100, 500, 500);
        setVisible(true);
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(roomNumbertf.getText());
                String clean = cleaningStatusCb.getSelectedItem().toString();
                String available =avaibleCb.getSelectedItem().toString();
                String price =pricetf.getText();
                String bed = bedTypeCb.getSelectedItem().toString();

                try {
                    Conn conn = new Conn(); String querry = "insert into room values('" + number + "', '" + clean + "', '" + available + "', '" + price + "','" + bed + "')";
                    conn.s.executeUpdate(querry); JOptionPane.showMessageDialog(null, "Employee added successfully");
                    setVisible(false); }
                catch (Exception ae) { ae.printStackTrace(); }

            }

        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
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
    private JComboBox avaibleCb;

    public void actionPerformed(ActionEvent e) {
    }



        public static void main (String[]args){
            new AddRooms();
        }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem AddRoom,AddDri,AddEmp,reception;
    Dashboard(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0, 0, 1550, 1000);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("S.E.B.E. Corporation welcomes you ");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma",Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar bar = new JMenuBar();
        bar.setBounds(0, 0, 1550, 30);
        image.add(bar);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.BLACK);
        bar.add(hotel);

        reception = new JMenuItem("Reception");
        hotel.add(reception);
        reception.addActionListener(this);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLACK);
        bar.add(admin);

        AddEmp = new JMenuItem("Add Employee");
        AddEmp.addActionListener(this);

        admin.add(AddEmp);

        AddRoom = new JMenuItem("Add Room");
        admin.add(AddRoom);
        AddRoom.addActionListener(this);

        AddDri = new JMenuItem("Add Driver");
        admin.add(AddDri);
        AddDri.addActionListener(this);


        setVisible(true);
    }
    public static void main(String[] arcgs){
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == AddEmp){
            new AddEmployee();
           setVisible(false);

        } else if (e.getSource() == AddRoom) {
            new AddRooms();
            setVisible(false);
        } else if (e.getSource() == AddDri) {
            new AddDriver();
            setVisible(false);

        } else if (e.getSource() == reception) {
            new  Reception();
            setVisible(false);
        }

    }
}

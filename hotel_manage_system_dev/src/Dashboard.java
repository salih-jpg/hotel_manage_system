import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    Dashboard(){
        setBounds(0, 0, 1550, 1000);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("Acme Corporation welcomes you villain!");
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

        JMenuItem reception = new JMenuItem("Reception");
        hotel.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLACK);
        bar.add(admin);

        JMenuItem AddEmp = new JMenuItem("Add Employee");

        admin.add(AddEmp);

        JMenuItem AddRoom = new JMenuItem("Add Room");
        admin.add(AddRoom);

        JMenuItem AddDri = new JMenuItem("Add Driver");
        admin.add(AddDri);


        setVisible(true);
    }
    public static void main(String[] arcgs){
        new Dashboard();
    }
}

import javax.swing.*;

public class hotel_manage_system extends JFrame {

    hotel_manage_system(){
        setBounds(100, 100, 1250, 565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel img = new JLabel(i1);
        add(img);
        setVisible(true);
    }


    public static void main(String[] args) {
      new hotel_manage_system();
    }
}
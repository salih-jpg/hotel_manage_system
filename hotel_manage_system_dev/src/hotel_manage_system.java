import javax.swing.*;
import java.awt.*;

public class hotel_manage_system extends JFrame {

    hotel_manage_system(){
        setBounds(100, 100, 1250, 565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1366, 565);
        add(img);

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        img.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif",Font.PLAIN,24));
        img.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
      new hotel_manage_system();
    }
}
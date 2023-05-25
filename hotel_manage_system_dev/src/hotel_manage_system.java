import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hotel_manage_system extends JFrame implements ActionListener {

    hotel_manage_system(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        JLabel text2 = new JLabel("S.E.B.E");
        text2.setBounds(150, 350, 1000, 90);
        text2.setForeground(Color.RED);
        text2.setFont(new Font("serif",Font.PLAIN,50));
        img.add(text2);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif",Font.PLAIN,24));
        next.addActionListener(this);
        img.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(true);
            text2.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(false);
            text2.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();

    }


    public static void main(String[] args) {
      new hotel_manage_system();
    }
}
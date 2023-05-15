import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel user = new JLabel("Usurname");
        user.setBounds(40, 70, 100, 30);
        add(user);

        JTextField username = new JTextField ();
        username.setBounds(150, 20, 150, 30);
        add(username);


        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 20, 100, 30);
        add(pass);

        JTextField password = new JTextField ();
        password.setBounds(150, 70, 150, 30);
        add(password);

        JButton login = new JButton("Login");
        login.setBounds(40 , 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(180 , 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img2 = new JLabel(i3);
        img2.setBounds(350, 350, 200, 200);
        add(img2);



        setBounds(500, 200, 600, 300);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Login();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    Login(){

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel text = new JLabel("ACME H.M.S");
        text.setBounds(20, 200, 1000, 90);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif",Font.PLAIN,24));
        add(text);

        JLabel user = new JLabel("Usurname");
        user.setBounds(40, 20, 100, 30);
        add(user);

         username = new JTextField ();
        username.setBounds(150, 20, 150, 30);
        add(username);


         JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

         password = new JPasswordField ();
        password.setBounds(150, 70, 150, 30);
        add(password);

         login = new JButton("Login");
        login.setBounds(40 , 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         cancel = new JButton("Cancel");
        cancel.setBounds(180 , 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img2 = new JLabel(i3);
        img2.setBounds(350, 10, 200, 200);
        add(img2);



        setBounds(500, 200, 600, 300);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String user = username.getText();
            String pass = password.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }


            }catch (Exception ae){
                ae.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }
}

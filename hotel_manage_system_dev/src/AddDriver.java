import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame {
    private JPanel panel1;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel Acme;
    private JComboBox ComboBox1;
    private JButton addDriverButton;
    private JTextField textField2;
    private JButton cancelButton;
    private JLabel Jlabe2;
    private JTextField textField1;
    private JComboBox ComboBox2;



    public AddDriver(){
        add(panel1);
        setBounds(100, 100, 500, 500);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        addDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name_Surname = textField1.getText();
                int age = Integer.parseInt(textField2.getText());
                String gender = ComboBox1.getSelectedItem().toString();
                String company =textField3.getText();
                String carModel =textField4.getText();
                String Available = ComboBox2.getSelectedItem().toString();
                if( age < 18){
                    JOptionPane.showMessageDialog(null, "Error!Please enter valid age for driver.");
                } else if (age >= 75) {
                    JOptionPane.showMessageDialog(null, "Error!Please enter valid age for driver.");
                }else {
                    try {
                        Conn conn = new Conn(); String querry = "insert into driver values('" + name_Surname + "', '" + age + "', '" + gender + "', '" + company + "','" + carModel + "','" + Available + "')";
                        conn.s.executeUpdate(querry); JOptionPane.showMessageDialog(null, "Employee added successfully");
                        setVisible(false);
                        new Dashboard();
                        }
                    catch (Exception ae) { ae.printStackTrace(); }

                }

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



}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends  JFrame {

    AddEmployee(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        i1.setImage(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(380, 60, 450,380);
        add(image);


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rbfemale);
        buttonGroup.add(rbmale);

        add(AddEmployeePanel);
        setBounds(350, 200, 850, 540);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = Integer.parseInt(tfage.getText());
                int salary = Integer.parseInt(tfsalary.getText());
                String name = tfname.getText();
                String email = tfemail.getText();
                String phoneNumber =tfphone_number.getText();
                String job = (String)jobs.getSelectedItem();

                String gender = null;
                if(rbmale.isSelected()){
                    gender = "male";
                }else if (rbfemale.isSelected()){
                    gender = "female";
                }
                 try {
                     Conn conn = new Conn();

                     String querry = "insert into employee values('"+name+"', '"+age+"', '"+salary+"', '"+email+"','"+phoneNumber+"','"+gender+"', '"+job+"')";

                     conn.s.executeUpdate(querry);
                     JOptionPane.showMessageDialog(null, "Employee added successfully");
                     setVisible(false);
                 }catch (Exception ae){
                     ae.printStackTrace();
                 }

            }
        });
    }

    private JPanel AddEmployeePanel;
    private JComboBox jobs;
    private JTextField tfemail;
    private JTextField tfphone_number;
    private JTextField tfsalary;

    private JTextField tfname;
    private JTextField tfage;
    private JRadioButton rbmale;
    private JRadioButton rbfemale;
    private JButton submitButton;



    public static void main(String[] args) {
        new AddEmployee();
    }


}

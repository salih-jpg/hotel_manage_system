import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CheckOut extends JFrame   {
    private JPanel checkout;
    private JLabel header;
    private JLabel customerIdLbl;
    private JLabel roomNumberLbl;
    private JLabel checkinTimeLabel;
    private JButton checkoutButton;
    private JButton backButton;

    private JLabel roomNumberTxt;
    private JLabel checkinTimeTxt;
    private JLabel checkoutTimeTxt;
    private JComboBox customers;
    private JButton searchBtn;

    CheckOut(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Date date = new Date();
        checkoutTimeTxt.setText("" +date);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
               customers.addItem(rs.getString("customerid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = (String) customers.getSelectedItem();
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where customerid = '"+customerId+"'");
                    while (rs.next()){
                        checkinTimeTxt.setText(rs.getString("time"));
                        roomNumberTxt.setText(rs.getString("room"));
                    }
                } catch (SQLException ex) {
                  ex.printStackTrace();
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = (String) customers.getSelectedItem();
                String deleteQuery = "DELETE FROM customer WHERE customerid =" + customerId  ;
                String setAvailibilityWQuery = "update room set available = 'Empty' where number = " + roomNumberTxt.getText();

                try {
                    Conn conn = new Conn();
                   conn.s.executeUpdate(setAvailibilityWQuery);
                    // Sorguyu çalıştır
                    int affectedRows = conn.s.executeUpdate(deleteQuery);

                    // Silme işlemi başarılıysa
                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null, "müşteri çıkış yaptı");
                        System.out.println("Tuple başarıyla silindi.");
                        setVisible(false);
                        new Reception();
                    } else {
                        System.out.println("Silme işlemi yapılamadı veya tuple bulunamadı.");
                    }

                } catch (SQLException ae) {
                    ae.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reception();
                setVisible(false);
            }
        });

        add(checkout);
        setBounds(300,200, 800, 400);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

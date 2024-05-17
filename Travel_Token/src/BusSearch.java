import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BusSearch extends JFrame {

    public BusSearch() {
        // Frame creation
        setTitle("Travel Token");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(new Color(230, 230, 250));
        setLocationRelativeTo(null);

        // Logo
        ImageIcon logo = new ImageIcon("D:/TripToken/buslogo2.png");
        setIconImage(logo.getImage());

        // Title
        JLabel name = new JLabel();
        name.setText("Travel Token");
        name.setBounds(84, 6, 400, 100);
        name.setFont(new Font("Algerian", Font.HANGING_BASELINE, 54));
        Color darkPurple = new Color(128, 0, 128);
        name.setForeground(darkPurple);

        // Image adding to frame
        ImageIcon img = new ImageIcon("D:/TripToken/bus_Ticket4.png");
        Image i1 = img.getImage().getScaledInstance(240, 100, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(130, 46, 300, 200);

        // Adding from and to fields
        JLabel from = new JLabel();
        from.setText("FROM : ");
        from.setBounds(90, 230, 100, 40);
        from.setFont(new Font("Algerian", Font.HANGING_BASELINE, 20));
        from.setForeground(darkPurple);

        // From text field
        JTextField tf1 = new JTextField();
        tf1.setBounds(160, 235, 120, 30);
        tf1.setFont(new Font("Algerian", Font.HANGING_BASELINE, 13));
        tf1.setForeground(Color.black);

        // Adding from and to fields
        JLabel to = new JLabel();
        to.setText("TO : ");
        to.setBounds(300, 230, 80, 40);
        to.setFont(new Font("Algerian", Font.HANGING_BASELINE, 20));
        to.setForeground(darkPurple);

        // To text field
        JTextField tf2 = new JTextField();
        tf2.setBounds(340, 235, 120, 30);
        tf2.setFont(new Font("Algerian", Font.HANGING_BASELINE, 13));
        tf2.setForeground(Color.black);

        // Button adding
        JButton b1 = new JButton();
        b1.setText("Search Buses");
        b1.setBounds(190, 300, 160, 40);
        b1.setFont(new Font("Algerian", Font.HANGING_BASELINE, 16));
        b1.setBackground(darkPurple);
        b1.setForeground(Color.white);
        b1.setBorder(BorderFactory.createLineBorder(darkPurple));

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    String fromCity = tf1.getText();
                    String toCity = tf2.getText();
                    new BusList(fromCity, toCity);
                }
            }
        });

        // Adding elements to frame
        add(l1);
        add(name);
        add(from);
        add(to);
        add(tf1);
        add(tf2);
        add(b1);
    }


}

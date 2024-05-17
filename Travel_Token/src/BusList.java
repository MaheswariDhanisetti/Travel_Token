import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BusList extends JFrame {
//    private String originCity;
//    private String destinationCity;

    BusList(String from, String to) {
//        this.originCity = from;
//        this.destinationCity = to;

        try {
            String url = "jdbc:mysql://localhost:3306/TripToken";
            String user = "root";
            String pass = "Mahi@28012005";

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) System.out.println("successfully connected");

            String query = "SELECT * FROM AvailableBuses WHERE origin_city = ? AND destination_city = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, from);
            pst.setString(2, to);

            ResultSet rs = pst.executeQuery();

            JFrame main = new JFrame("Available Buses");
            main.setSize(600, 400);
            main.setResizable(false);
            main.setLayout(new BorderLayout());
            main.setVisible(true);
            main.getContentPane().setBackground(new Color(230, 230, 250));
            main.setLocationRelativeTo(null);

            ImageIcon logo = new ImageIcon("D:/TripToken/buslogo2.png");
            main.setIconImage(logo.getImage());

            JPanel panel = new JPanel(new GridLayout(0, 8));
            panel.setBackground(new Color(230, 230, 250));

            if (!rs.isBeforeFirst()) {
                JLabel messageLabel = new JLabel("No buses found", SwingConstants.CENTER);
                messageLabel.setFont(messageLabel.getFont().deriveFont(20f));
                panel.setLayout(new GridBagLayout());
                panel.add(messageLabel);
            } else {
                panel.add(new JLabel("Bus ID"));
                panel.add(new JLabel("Travelers Name"));
                panel.add(new JLabel("Rating"));
                panel.add(new JLabel("Type"));
                panel.add(new JLabel("Origin City"));
                panel.add(new JLabel("Destination City"));
                panel.add(new JLabel("Price"));
                panel.add(new JLabel("View"));

                while (rs.next()) {
                    JButton viewButton = new JButton("View Bus");
                    viewButton.setBackground(new Color(128, 0, 128));
                    viewButton.setForeground(Color.WHITE);
                    viewButton.setPreferredSize(new Dimension(80, 20));
                    int busId = rs.getInt("busId");
                    String travelersName = rs.getString("TravelersName");
                    double rating = rs.getDouble("rating");
                    String type = rs.getString("Type");
                    String originCity = rs.getString("origin_city");
                    String destinationCity = rs.getString("Destination_city");
                    double price = rs.getDouble("price");

                    viewButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new BusArchitechture(busId, from, to, price);
                        }
                    });

                    panel.add(new JLabel(String.valueOf(busId)));
                    panel.add(new JLabel(travelersName));
                    panel.add(new JLabel(String.valueOf(rating)));
                    panel.add(new JLabel(type));
                    panel.add(new JLabel(originCity));
                    panel.add(new JLabel(destinationCity));
                    panel.add(new JLabel(String.valueOf(price)));
                    panel.add(viewButton);
                }
            }
            JScrollPane scrollPane = new JScrollPane(panel);
            main.add(scrollPane, BorderLayout.CENTER);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}

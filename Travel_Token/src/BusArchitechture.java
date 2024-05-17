import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BusArchitechture extends JFrame {

    public BusArchitechture(int busid, String originCity, String destinationCity, double price) {
        super();

        try {
            String url = "jdbc:mysql://localhost:3306/TripToken";
            String user = "root";
            String pass = "Mahi@28012005";

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) System.out.println("successfully connected");

            setTitle("Bus Seat Layout");
            setSize(600, 400);
            setLocationRelativeTo(null);
            setVisible(true);
            setResizable(false);
            getContentPane().setBackground(new Color(230, 230, 250));
            setLayout(null); // Set null layout for the main frame

            ImageIcon logo = new ImageIcon("D:/TripToken/buslogo2.png");
            setIconImage(logo.getImage());

            // Display bus ID, origin city, and destination city at the top
            JLabel titleLabel = new JLabel("BusID: " + busid + "    " + originCity + " ---> " + destinationCity, SwingConstants.CENTER);
            titleLabel.setBounds(0, 20, 600, 28);
            titleLabel.setFont(new Font("Mv Boli", Font.BOLD, 20));
            titleLabel.setForeground(new Color(128, 0, 128));
            getContentPane().add(titleLabel);

            // Create steering wheel icon
            ImageIcon steeringIcon = new ImageIcon("C:/Users/MAHESWARI/Downloads/steering.jpg");
            Image image = steeringIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            JLabel iconLabel = new JLabel(scaledIcon);
            iconLabel.setBounds(20, 100, 40, 40);
            getContentPane().add(iconLabel);

            // Color boxes and labels
            JPanel colorBox = new JPanel();
            colorBox.setBounds(120, 60, 24, 16);
            colorBox.setBackground(Color.LIGHT_GRAY);
            JLabel labelText = new JLabel("Unreserved");
            labelText.setBounds(150, 57, 100, 20);
            labelText.setForeground(Color.BLACK);
            labelText.setFont(new Font("Arial", Font.BOLD, 14));
            add(labelText);
            add(colorBox);

            JPanel colorBox1 = new JPanel();
            colorBox1.setBounds(260, 60, 24, 16);
            colorBox1.setBackground(Color.GREEN);
            JLabel labelText1 = new JLabel("Reserved");
            labelText1.setBounds(290, 57, 100, 20);
            labelText1.setForeground(Color.BLACK);
            labelText1.setFont(new Font("Arial", Font.BOLD, 14));
            add(labelText1);
            add(colorBox1);

            JPanel colorBox2 = new JPanel();
            colorBox2.setBounds(380, 60, 24, 16);
            colorBox2.setBackground(Color.CYAN);
            JLabel labelText2 = new JLabel("Selected");
            labelText2.setBounds(410, 57, 100, 20);
            labelText2.setForeground(Color.BLACK);
            labelText2.setFont(new Font("Arial", Font.BOLD, 14));
            add(labelText2);
            add(colorBox2);

            // Seat dimensions and positioning
            int seatHeight = 30;
            int seatWidth = 50;
            int seatSpacing = 10;
            int startX = 80;
            int startY = 0;
            int numRows = 5;
            int numColumns = 8;
            int fontSize = 9;
            int cnt = 1;

            // Panel to store seats
            JPanel busLayoutPanel = new JPanel(null);
            busLayoutPanel.setBounds(0, 100, 600, 320);
            busLayoutPanel.setBackground(new Color(230, 230, 250));


            // Fetch reservation data from the database
            PreparedStatement stmt = con.prepareStatement("SELECT ReservedSeats FROM BusSeatReservations WHERE BusID = ?");
            stmt.setInt(1, busid);
            ResultSet rs = stmt.executeQuery();
            String reservedSeats = "";
            if (rs.next()) {
                reservedSeats = rs.getString("ReservedSeats");
            }

            // ActionListener for seat buttons
            ActionListener seatButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton seatButton = (JButton) e.getSource();
                    if (seatButton.getBackground().equals(Color.LIGHT_GRAY)) {
                        seatButton.setBackground(Color.CYAN);
                    } else {
                        seatButton.setBackground(Color.LIGHT_GRAY);
                    }
                }
            };

            // Create seat buttons and set background color based on reservation status
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    int seatnum = i * numColumns + (j + 1);

                    // Check if seat number is within the seat numbers to be removed
                    if (seatnum >= 17 && seatnum <= 23) {
                        continue;
                    }

                    JButton seatButton = new JButton("S" + cnt);
                    seatButton.setBounds(startX + j * (seatWidth + seatSpacing), startY + (i * (seatHeight + seatSpacing)), seatWidth, seatHeight);
                    seatButton.setFont(new Font("Sanserif", Font.PLAIN, fontSize));


                    // Check if the seat is reserved
                    boolean isReserved = false;
                    for (String reservedSeat : reservedSeats.split(",")) {
                        if (reservedSeat.trim().equals("S" + cnt)) {
                            isReserved = true;
                            break;
                        }
                    }
                    cnt++;

                    // Set background color based on reservation status
                    if (isReserved) {
                        seatButton.setBackground(Color.GREEN);
                        seatButton.setForeground(Color.black);
                        seatButton.setEnabled(false);
                    } else {
                        seatButton.setBackground(Color.LIGHT_GRAY);
                        seatButton.setForeground(Color.black);
                    }

                    busLayoutPanel.add(seatButton);
                    seatButton.addActionListener(seatButtonListener);
                }
            }

            add(busLayoutPanel);

            JButton reserve = new JButton("Reserve Seats");
            reserve.setBounds(250, 320, 120, 30); // Set bounds for positioning and size
            reserve.setBackground(new Color(128, 0, 128));
            reserve.setForeground(Color.white);
            add(reserve);

            // Action listener for the "Reserve Seats" button
            reserve.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder selectedSeats = new StringBuilder();
                    int numSelectedSeats = 0;
                    double totalPrice = 0.0;

                    Component[] components = busLayoutPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JButton) {
                            JButton seatButton = (JButton) component;
                            if (seatButton.getBackground().equals(Color.CYAN)) {
                                String seatNumber = seatButton.getText();
                                selectedSeats.append(seatNumber).append(", ");
                                numSelectedSeats++;
                            }
                        }
                    }

                    if (numSelectedSeats > 0) {
                        // Remove the trailing comma and space
                        selectedSeats.setLength(selectedSeats.length() - 2);

                        // Calculate total price and price per seat
                        totalPrice = price * numSelectedSeats;
                        double pricePerSeat = price;

                        String message = "Selected Seats: " + selectedSeats.toString() + "\n" +
                                "Price Per Seat:  \u20B9" + pricePerSeat + "\n" +
                                "Total Cost:  \u20B9" + totalPrice;


                        // Show popup message
                        int option = JOptionPane.showConfirmDialog(null, message, "Reservation Details", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            // Open passenger details window only if user clicked "OK"
                            dispose(); // Close current window
                            new PassengerDetails(selectedSeats.toString(),totalPrice,busid); // Open passenger details window
                            System.out.println("you clicked ok");
                        }
                    } else {
                        String message = "No seats selected for reservation.";
                        JOptionPane.showMessageDialog(null, message);
                    }
                }
            });


        } catch (SQLException e) {
            System.out.println(e);
        }
    }



}

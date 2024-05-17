import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Payment extends JFrame {

    Payment(String seats, double totalprice, int busid, String name, int age, String mobileNumber, String gender, String state) {
        try {
            String url = "jdbc:mysql://localhost:3306/TripToken";
            String user = "root";
            String pass = "Mahi@28012005";

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) System.out.println("successfully connected");

            setTitle("Payment Details");
            setSize(600, 400); // Set frame size
            setLocationRelativeTo(null);
            setVisible(true);
            setResizable(false);
            getContentPane().setBackground(new Color(230, 230, 250));
            setLayout(null); // Set null layout for the main frame

            ImageIcon logo = new ImageIcon("D:/TripToken/buslogo2.png");
            setIconImage(logo.getImage());

            // Heading Label
            JLabel headingLabel = new JLabel("Payment Details");
            headingLabel.setBounds(180, 20, 300, 28);
            headingLabel.setFont(new Font("Algerian", Font.HANGING_BASELINE, 20)); // Set font to Algerian with HangingBaseline style
            headingLabel.setForeground(new Color(128, 0, 128));
            getContentPane().add(headingLabel);

            // Total Price Label
            JLabel totalPriceLabel = new JLabel("Total Amount to Pay: ₹" + totalprice);
            totalPriceLabel.setBounds(50, 60, 300, 20);
            getContentPane().add(totalPriceLabel);

            // Bank Name Label and Textfield
            JLabel bankNameLabel = new JLabel("Bank Name:");
            bankNameLabel.setBounds(50, 100, 100, 20);
            getContentPane().add(bankNameLabel);
            JTextField bankNameField = new JTextField();
            bankNameField.setBounds(150, 100, 200, 25);
            getContentPane().add(bankNameField);

            // Card Number Label and Textfield
            JLabel cardNumberLabel = new JLabel("Card Number:");
            cardNumberLabel.setBounds(50, 140, 100, 20);
            getContentPane().add(cardNumberLabel);
            JTextField cardNumberField = new JTextField();
            cardNumberField.setBounds(150, 140, 200, 25);
            getContentPane().add(cardNumberField);

            // Expiry Date Label and Textfield
            JLabel expiryDateLabel = new JLabel("Expiry Date:");
            expiryDateLabel.setBounds(50, 180, 100, 20);
            getContentPane().add(expiryDateLabel);
            JTextField expiryDateField = new JTextField();
            expiryDateField.setBounds(150, 180, 100, 25);
            getContentPane().add(expiryDateField);

            // CVV Label and Textfield
            JLabel cvvLabel = new JLabel("CVV:");
            cvvLabel.setBounds(50, 220, 100, 20);
            getContentPane().add(cvvLabel);
            JTextField cvvField = new JTextField();
            cvvField.setBounds(150, 220, 100, 25);
            getContentPane().add(cvvField);

            // Radio Buttons for Card Type
            JLabel cardTypeLabel = new JLabel("Card Type:");
            cardTypeLabel.setBounds(50, 260, 100, 20);
            getContentPane().add(cardTypeLabel);
            JRadioButton debitRadioButton = new JRadioButton("Debit");
            debitRadioButton.setBounds(150, 260, 80, 20);
            JRadioButton creditRadioButton = new JRadioButton("Credit");
            creditRadioButton.setBounds(250, 260, 80, 20);
            ButtonGroup cardTypeGroup = new ButtonGroup();
            cardTypeGroup.add(debitRadioButton);
            cardTypeGroup.add(creditRadioButton);
            getContentPane().add(debitRadioButton);
            getContentPane().add(creditRadioButton);

            // Pay Button
            JButton payButton = new JButton("Pay");
            payButton.setBounds(210, 300, 150, 30); // Set bounds for button
            payButton.setBackground(new Color(128, 0, 128));
            payButton.setForeground(Color.white);
            getContentPane().add(payButton);

            // Add ActionListener to Pay button
            payButton.addActionListener(e -> {
                // Check if any field is empty
                if (bankNameField.getText().isEmpty() || cardNumberField.getText().isEmpty() ||
                        expiryDateField.getText().isEmpty() || cvvField.getText().isEmpty() ||
                        (!debitRadioButton.isSelected() && !creditRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Insert data into database
                    try {
                        String query = "INSERT INTO passengerdetails (BusID, SelectedSeats, Name, Age, State, Gender, MobileNumber, AmountPaid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = con.prepareStatement(query);
                        statement.setInt(1, busid);
                        statement.setString(2, seats);
                        statement.setString(3, name);
                        statement.setInt(4, age);
                        statement.setString(5, state);
                        statement.setString(6, gender);
                        statement.setString(7, mobileNumber);
                        statement.setDouble(8, totalprice);
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Payment successful. Your seats have been Reserved Successfully");

                            // Update ReservedSeats column in busseatreservations table
//                            String updateQuery = "UPDATE busseatreservations SET ReservedSeats = CONCAT(ReservedSeats, ?), UnreservedSeats = REPLACE(UnreservedSeats, ?, '') WHERE BusID = ?";
                            String updateQuery = "UPDATE busseatreservations SET ReservedSeats = CONCAT(ReservedSeats, ?), UnreservedSeats = REPLACE(CONCAT(',', UnreservedSeats, ','), ?, ',') WHERE BusID = ?";

                            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                            updateStatement.setString(1, "," + seats);
                            updateStatement.setString(2, seats);
                            updateStatement.setInt(3, busid);
                            int updatedRows = updateStatement.executeUpdate();
                            if (updatedRows > 0) {
                                System.out.println("Reserved seats updated successfully.");
                            } else {
                                System.out.println("Failed to update reserved seats.");
                            }

                            // Dispose the payment window
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to insert data into database.");
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
            });

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}

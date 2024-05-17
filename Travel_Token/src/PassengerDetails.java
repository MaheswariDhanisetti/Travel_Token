import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PassengerDetails extends JFrame {
    private String seats;

    PassengerDetails(String seats, double totalprice, int busid) {

        try {
            String url = "jdbc:mysql://localhost:3306/TripToken";
            String user = "root";
            String pass = "Mahi@28012005";

            Connection con = DriverManager.getConnection(url, user, pass);
            if (con != null) System.out.println("successfully connected");

            setTitle("Passenger Details");
            setSize(600, 400); // Set frame size
            setLocationRelativeTo(null);
            setVisible(true);
            setResizable(false);
            getContentPane().setBackground(new Color(230, 230, 250));
            setLayout(null); // Set null layout for the main frame

            ImageIcon logo = new ImageIcon("D:/TripToken/buslogo2.png");
            setIconImage(logo.getImage());

            // Heading Label
            JLabel headingLabel = new JLabel("Passenger Details");
            headingLabel.setBounds(180, 20, 300, 28);
            headingLabel.setFont(new Font("Algerian", Font.HANGING_BASELINE, 20)); // Set font to Algerian with HangingBaseline style
            headingLabel.setForeground(new Color(128, 0, 128));
            getContentPane().add(headingLabel);

            // Display selected seats
            JLabel selectedSeatsLabel = new JLabel("Selected Seats: " + seats);
            selectedSeatsLabel.setBounds(50, 60, 500, 20);
            selectedSeatsLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            getContentPane().add(selectedSeatsLabel);

            // Name Field
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setBounds(50, 95, 100, 20);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            JTextField nameField = new JTextField();
            nameField.setBounds(150, 95, 250, 25); // Increased text field size
            getContentPane().add(nameLabel);
            getContentPane().add(nameField);

            // Age Field
            JLabel ageLabel = new JLabel("Age:");
            ageLabel.setBounds(50, 135, 100, 20);
            ageLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            JTextField ageField = new JTextField();
            ageField.setBounds(150, 135, 100, 25); // Increased text field size
            getContentPane().add(ageLabel);
            getContentPane().add(ageField);

            // State Selection Field
            JLabel stateLabel = new JLabel("Select State:");
            stateLabel.setBounds(50, 175, 100, 20);
            stateLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
            JComboBox<String> stateComboBox = new JComboBox<>(states);
            stateComboBox.setBounds(150, 175, 250, 25); // Increased combo box size
            getContentPane().add(stateLabel);
            getContentPane().add(stateComboBox);

            // Gender Field
            JLabel genderLabel = new JLabel("Gender:");
            genderLabel.setBounds(50, 215, 100, 20);
            genderLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            JRadioButton maleRadioButton = new JRadioButton("Male");
            maleRadioButton.setBounds(150, 215, 80, 20);
            JRadioButton femaleRadioButton = new JRadioButton("Female");
            femaleRadioButton.setBounds(250, 215, 80, 20);
            JRadioButton otherRadioButton = new JRadioButton("Other");
            otherRadioButton.setBounds(350, 215, 80, 20);
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);
            genderGroup.add(otherRadioButton);
            getContentPane().add(genderLabel);
            getContentPane().add(maleRadioButton);
            getContentPane().add(femaleRadioButton);
            getContentPane().add(otherRadioButton);

            // Mobile Number Field
            JLabel mobileLabel = new JLabel("Mobile Number:");
            mobileLabel.setBounds(50, 255, 150, 20);
            mobileLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Increased font size
            JTextField mobileField = new JTextField();
            mobileField.setBounds(160, 255, 240, 25); // Increased text field size
            getContentPane().add(mobileLabel);
            getContentPane().add(mobileField);

            // Proceed to Pay Button
            JButton proceedButton = new JButton("Proceed to Pay");
            proceedButton.setBounds(210, 310, 150, 30); // Set bounds for button
            proceedButton.setBackground(new Color(128, 0, 128));
            proceedButton.setForeground(Color.white);
            getContentPane().add(proceedButton);


            // Add ActionListener to Proceed button
            proceedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check if any field is empty or gender is not selected
                    if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || mobileField.getText().isEmpty() ||
                            stateComboBox.getSelectedItem() == null ||
                            (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected() && !otherRadioButton.isSelected())) {
                        JOptionPane.showMessageDialog(null, "Please fill all fields.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Get user data
                        String name = nameField.getText();
                        int age = Integer.parseInt(ageField.getText());
                        String state = (String) stateComboBox.getSelectedItem();
                        String gender = maleRadioButton.isSelected() ? "Male" : (femaleRadioButton.isSelected() ? "Female" : "Other");
                        String mobile = mobileField.getText();

                        // Open payment window and pass selected seats, total price, bus ID, and user data
                        Payment paymentWindow = new Payment(seats, totalprice, busid, name, age, mobile, gender, state);

                        // Dispose current window
                        dispose();
                    }
                }
            });

        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}

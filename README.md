🎟️Bus Ticket Booking Application using Java Swing

Overview
I am pleased to present a comprehensive bus ticket booking application developed using Java Swing. This application provides a seamless and user-friendly interface for booking bus tickets.It integrates with a MySQL database to manage bus seats reservation status , buses availability and passenger details dynamically.

💻Technologies Used
Java Swing: For creating the graphical user interface.
MySQL: For database management.
JDBC: For connecting Java applications to the database.

🎯Project Features

1. 🏠Home Window:
   Input Fields: Text fields for entering the 'From' and 'To' destinations.
   Search Button: Initiates a search for buses that match the specified criteria.

2. 🚌Bus List Window:
   Bus Details: Displays a list of buses with details such as Bus ID, Name, Type (AC/Non-AC), and Price per seat.
   View Bus Option: Allows users to view the seat layout of the selected bus.

3. 💺Bus Seat Layout Window:
   Seat Layout Display: Graphical representation of the bus seats.
   Seat Selection: Users can select or unselect seats interactively.
   Legend: Color-coded representation of seat status (Green: Reserved, Grey: Unreserved, Blue: Selected).
   Reserve Seats Button: Proceeds to the user details entry after seat selection.

4. 👤User Details Window:
   Form Fields: Inputs for user details (Name, Age, Gender, State, Phone Number).
   Confirmation Pop-up: Displays selected seats, cost per seat, and total cost.

5. 💳Payment Window:
   Payment Details: Fields for entering bank details, card type, CVV, and card number.
   Pay Button: Simulates payment processing. If all fields are correctly filled, a confirmation message shows successful seat reservation and payment. If any field is unfilled, an error pop-up prompts the user to complete all fields.
   Note: This prototype does not include real-time payment processing. It only simulates the payment process for demonstration purposes.


Functional Workflow

1. 🔍Bus Search:
   - Users enter the 'From' and 'To' destinations in the Home Window and click 'Search'.
   - The application retrieves matching buses from the 'availablebuses' table in the database.

2. Seat Selection:
   - Users view bus details and select a bus in the Bus List Window to view its seat layout.
   - In the Bus Seat Layout Window, users can select and unselect seats. The legend aids in identifying the status of each seat.

3. Seat Reservation:
   - After selecting seats, users proceed to the User Details Window.
   - A pop-up confirms the selection and displays the total cost.
   - Users enter their details and proceed to payment.

4.💰Payment Process:
   - Users enter their payment details in the Payment Window.
   - Clicking 'Pay' shows a confirmation message if all fields are filled correctly, indicating successful seat reservation and payment ✅. If any field is missing, an error message prompts the user to fill all fields.
   - The application updates the 'passengerdetails' table with user details and modifies the seat status in the 'busseatreservation' table.

🔄️Database Integration

Bus Search: Queries the 'availablebuses' table to fetch buses based on user input.
Seat Reservation: Updates seat status in the 'busseatreservation' table and stores passenger details in the 'passengerdetails' table upon successful payment simulation.

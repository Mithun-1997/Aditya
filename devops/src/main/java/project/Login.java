package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read user details
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your email ID: ");
        String userEmail = scanner.nextLine();

        System.out.print("Enter your Mobile Number: ");
        String userMobileNumber = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String userPassword = scanner.nextLine();

        // Validate mobile number using Validation class
        if (!Validation.isValidMobileNumber(userMobileNumber)) {
            System.out.println("⚠️ Invalid Mobile Number! Please enter a valid 10-digit mobile number.");
        } else {
            // Store user details in DB
            try (Connection con = JdbcConnection.getConnection()) {
                String query = "INSERT INTO userlist (name, email, mobile, password) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, userName);
                pstmt.setString(2, userEmail);
                pstmt.setString(3, userMobileNumber);
                pstmt.setString(4, userPassword);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("✅ User registered successfully!");
                } else {
                    System.out.println("❌ Registration failed. Please try again.");
                }
            } catch (SQLException | IOException e) {
                System.out.println("❌ Database Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

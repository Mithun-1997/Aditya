package project;

public class Validation {
    public static boolean isValidMobileNumber(String mobileNumber) {
        return mobileNumber != null && mobileNumber.matches("\\d{10}");
    }
}

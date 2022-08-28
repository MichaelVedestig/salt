package chapter8;

import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {

        String userName = "Bjarne";
        String oldPassword = "Password";
        System.out.println("Enter new password:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        if (password.length() < 8)
            System.out.println("Password needs to be at least 8 characters.");
        if (!checkForUpperCase(password))
            System.out.println("Password must contain at least 1 uppercase letter.");
        if (!checkForSpecial(password))
            System.out.println("Password must contain at least 1 special character.");
        if (password.contains(userName))
            System.out.println("Password cannot contain your username.");
        if (password.compareTo(oldPassword) == 0)
            System.out.println("the new Password cannot be the same as you old password");
    }


    public static boolean checkForSpecial(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i)))
                return true;
        }
        return false;
    }

    public static boolean checkForUpperCase(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}


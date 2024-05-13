import java.util.Scanner;

public class Main {
    static final String Password = "Password";
    static final Integer maxTries = 3;

    public static void login() throws MaximumAttemptsExceededException, IncorrectPasswordException {
        Scanner scanner = new Scanner(System.in);
        int loginAttempts = 0;

        while (loginAttempts != maxTries) {
            System.out.print("Enter your password: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(Password)) {
                System.out.println("Login is successful!");
                return;
            } else {
                loginAttempts++;
                int remainingAttempts = maxTries - loginAttempts;
                System.out.println("Invalid password. " + remainingAttempts + " attempts remaining.");
            }
        }

        throw new MaximumAttemptsExceededException(
                "You’ve exceeded the maximum login attempts. Please try again later.");
    }

    public static void main(String[] args) {
        try {
            login();
        } catch (IncorrectPasswordException e) {
            System.out.println("Invalid password entered.");
        } catch (MaximumAttemptsExceededException e) {
            System.out.println("You’ve reached the maximum login attempts.");
        }
    }
}
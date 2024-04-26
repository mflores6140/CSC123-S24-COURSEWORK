
import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            scanner.next(); // Consume invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return input;
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static boolean getBoolean(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
            System.out.print(prompt);
            scanner.next(); 
        }
        boolean input = scanner.nextBoolean();
        scanner.nextLine(); 
        return input;
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            scanner.next(); 
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); 
        return input;
    }
}

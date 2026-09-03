import java.util.Scanner;

public class P1 {

        // Method demonstrating 'throw'
        public static void validateAge(int age) {

                if (age < 18) {

                        // 'throw' explicitly creates and raises an exception
                        throw new IllegalArgumentException(
                                        "Age must be at least 18. Provided: " + age);
                }

                System.out.println(
                                "Access granted. Age is valid. The code is correct");
        }

        public static void main(String[] args) {

                // --- 1. Basic try-catch-finally ---
                System.out.println(
                                "--- 1. Basic try-catch-finally ---");

                try {

                        int numerator = 50;
                        int denominator = 0;

                        int result = numerator / denominator;

                        System.out.println("Result: " + result);

                } catch (ArithmeticException e) {

                        System.out.println(
                                        "Caught ArithmeticException: "
                                                        + e.getMessage());

                } finally {

                        // finally block always executes
                        System.out.println(
                                        "Finally block executed (cleanup step).");
                }

                // --- 2. Multi-catch Block ---
                System.out.println(
                                "\n--- 2. Multi-catch Block ---");

                try {

                        String str = null;
                        int[] arr = new int[2];

                        // This would cause NullPointerException:
                        // System.out.println(str.length());

                        // This causes ArrayIndexOutOfBoundsException
                        arr[5] = 100;

                } catch (
                                ArrayIndexOutOfBoundsException
                                | NullPointerException e) {

                        System.out.println(
                                        "Caught combined exception type: "
                                                        + e.getClass().getSimpleName());
                }

                // --- 3. Try-with-resources ---
                System.out.println(
                                "\n--- 3. Try-with-resources ---");

                String simulatedInput = "Java Dev";

                // Scanner is automatically closed
                try (Scanner scanner = new Scanner(simulatedInput)) {

                        System.out.println(
                                        "Read from AutoCloseable scanner: "
                                                        + scanner.nextLine());
                }

                // --- 4. Handling throw and throws ---
                System.out.println(
                                "\n--- 4. Handling 'throw' and 'throws' ---");

                try {

                        validateAge(15);

                } catch (IllegalArgumentException e) {

                        System.out.println(
                                        "Caught validation error: "
                                                        + e.getMessage());
                }
        }
}
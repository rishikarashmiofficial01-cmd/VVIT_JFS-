import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cumulative percentage: ");
        double percentage = sc.nextDouble();

        try {

            // Check whether percentage is within valid range
            if (percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException(
                        "Percentage must be between 0 and 100.");
            }

            // Find grade
            if (percentage > 85) {
                System.out.println("Grade: Distinction");
            } else if (percentage >= 70) {
                System.out.println("Grade: First Class");
            } else {
                System.out.println("Grade: Not Eligible");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
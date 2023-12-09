import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter 5 integers: ");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            sum += number;
        }
        scanner.close();

        double average = (double) sum / 5;
        System.out.println("The average of 5 integers: " + average);
    }
}

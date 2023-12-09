import java.util.*;

public class Reverse {
    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            int reverse = 0;
            for(; num!= 0; num /= 10) {
                int digit = num % 10;
                reverse = reverse * 10 + digit;
            }
            scanner.close();
            System.out.println("Reversed Order: " + reverse);
        }
    }
}

import java.util.*;

public class Main9 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Integer: ");
        int number = scanner.nextInt();
        scanner.close();

        if (number % 5 == 0) {
            System.out.println(number + " is a multiple of 5.");
        } else {
            System.out.println(number + " is not a multiple of 5.");
        }
    }
}

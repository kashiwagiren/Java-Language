import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int number = scanner.nextInt();
        scanner.close();

        int reversedNum = 0;
        while(number != 0) {
            int digit = number % 10;
            reversedNum = reversedNum * 10 + digit;
            number /= 10;
        }
        System.out.println("Reversed integer: " + reversedNum);
    }
}

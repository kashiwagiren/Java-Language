import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find factorial: ");
        int number = scanner.nextInt();
        scanner.close();

        long factorial = 1;
        for(int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of "+ number +" is: " + factorial);
    }
}
